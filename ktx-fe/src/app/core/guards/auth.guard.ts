import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { HrStorage } from 'angularx-score';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor(
        private router: Router
    ) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
          const userToken = HrStorage.getUserToken();
        // const tokenExpires = Number(CommonUtils.getTokenExpiresIn());
        // console.log('tokenExpires', tokenExpires);
        // if (!tokenExpires || tokenExpires < new Date().getTime()
        if (!userToken) {
          this.router.navigate(['/auth/login']);
          return false;
        }
        return true;
      }

}
