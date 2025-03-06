import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContentLayoutComponent } from 'src/app/layout/content-layout/content-layout.component';
import { L10nIntlModule, L10nTranslationModule, L10nTranslationService } from 'angular-l10n';
import { ConfirmationService } from 'primeng/api';
import { TranslationLoader, l10nConfig } from './l10n-config';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './core/interceptors';
import { AuthGuard, NoAuthGuard } from './core/guards';
import { SharedModule } from 'angularx-score';
import { LayoutModule } from './layout/layout.module';
import { TagModule } from 'primeng/tag';


@NgModule({
  declarations: [
    AppComponent,
    ContentLayoutComponent,
  ],
  imports: [
    LayoutModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    L10nTranslationModule.forRoot(
      l10nConfig,
      {
        translationLoader: TranslationLoader
      }
    ),
    L10nIntlModule,
    TagModule
  ],
  providers: [
    L10nTranslationService,
    ConfirmationService,
    AuthGuard,
    NoAuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
