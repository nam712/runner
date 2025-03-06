import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HttpResponse
} from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CommonUtils } from 'angularx-score';
import { HrStorage } from 'angularx-score';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  urlsToNotUse: Array<string>;
  constructor(public router: Router,
    public commonUtil: CommonUtils
  ) {
    this.urlsToNotUse = [
      '/v1/permission/sys-user/authenticate',
      '/v1/permission/sys-user/get-captcha-code',
      '/v1/permission/sys-user/password'
    ];

  }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.isValidRequestForInterceptor(request.url)) {
      request = request.clone({
        setHeaders: {
          // 'Authorization': `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJENTMuVFMuQjEuMDAzIiwiaWF0IjoxNzEyODQ3MTg3LCJleHAiOjE3MTI4NTA3ODd9.U1zJcyFQq9Y3T2E1YrntWqWmhT8CmgYrlJdJmPDbuYU`,
          'Authorization': `Bearer ${this.getAccessToken()}`,
          // 'viettel-api-key': `c9f55dab-d44a-43c0-a922-d7133efdb28d`,
          // 'Current-Language': this.getCurrentLanguageCode(),
          // 'Current-Market': this.getCurrentMarket(),
          // 'sso-two-factor-ticket': this.getTwoFactorTicket(),
          // 'session-app': this.getSessionId()
        }
      });
      return next.handle(request).pipe(
        tap(event => {
          if (event instanceof HttpResponse) {
            const { type, code } = event.body || {};
            if (type == 'ERROR') {
              this.commonUtil.toastMessage('error', code);
            } else if (type == 'WARN') {
              this.commonUtil.toastMessage('warn', code);
            }
          }
        }, error => {
          if (error.status === 401 || error.status === 403) {
            this.commonUtil.toastMessage('error', 'common.error.haveNoPermission');
            // Do later: set currentUrl when redirect from SSO
            // HrStorage.setCurrentUrl(this.router.url);
            // this.router.navigate(['/auth-sso']);
            CommonUtils.logoutAction(this.router);
          }
        })
      );
    }
    return next.handle(request);
  }

  private isValidRequestForInterceptor(requestUrl: string): boolean {
    for (let address of this.urlsToNotUse) {
      if (new RegExp(address).test(requestUrl)) {
        return false;
      }
    }
    return true;
  }

  getCurrentLanguageCode(): string {
    const selectedLang = HrStorage.getSelectedLang();
    if (selectedLang == null) {
      return 'en';
    } else {
      return selectedLang.code;
    }
  }
  getCurrentMarket(): string {
    const selectedMarket = HrStorage.getSelectedMarket();
    if (selectedMarket == null) {
      return '';
    } else {
      return selectedMarket.marketCompanyId;
    }
  }
  getAccessToken() {
    const userToken = HrStorage.getUserToken();
    if (userToken == null) {
      return '';
    } else {
      return userToken.access_token;
    }
  }
  // getTwoFactorTicket() {
  //   if (window.TwoFactor && window.TwoFactor.getTicket()) {
  //     return window.TwoFactor.getTicket();
  //   }
  //   return '';
  // }
  getSessionId(){
    const sessionId = HrStorage.getSessionId();
    if(sessionId != null){
      return sessionId;
    }
    return '';
  }
}
