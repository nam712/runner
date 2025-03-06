import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class KTXCommonUtils {
    public static createYearOptions(): any {
        const currentYear = new Date().getFullYear();
        const years = Array.from({ length: 51 }, (_, i) => currentYear - i);

        return years.map(e => ({ value: e, label: e }));
    }

    public static createMonthOptions(): any {
        const months = Array.from({ length: 12 }, (_, i) => i + 1);

        return months.map(e => ({ value: e, label: e }));
    }
}