import { Injectable } from "@angular/core";
import { L10nConfig, L10nProvider, L10nTranslationLoader } from "angular-l10n";
import { Observable, from } from "rxjs";
// https://github.com/robisim74/angular-l10n
export const l10nConfig: L10nConfig = {
    format: 'language-region',
    providers: [
        { name: 'app', asset: 'app' }
    ],
    cache: true,
    keySeparator: '.',
    defaultLocale: { language: 'vi-VN', currency: 'VND', timeZone: 'Asia/Ho_Chi_Minh' },
    schema: [
        { locale: { language: 'vi-VN', currency: 'VND', timeZone: 'Asia/Ho_Chi_Minh' } },
        { locale: { language: 'en-US', currency: 'USD', timeZone: 'America/Los_Angeles' } },
    ]
};

@Injectable() export class TranslationLoader implements L10nTranslationLoader {
    public get(language: string, provider: L10nProvider): Observable<{ [key: string]: any }> {
        const data = import(`../assets/locale/${language}/${provider.asset}.json`);
        return from(data);
    }
}