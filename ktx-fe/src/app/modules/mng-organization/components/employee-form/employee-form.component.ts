import { Component, Injector } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { EmployeeService } from '../../services/employee.service';
import { ACTION_FORM, GENDER_OPTIONS, OBJ_TYPE_OPTIONS, RESOURCE, STATUS_DEFENCE_SECURITY } from 'src/app/core/app-config';
import { CommonUtils } from 'angularx-score';
import { CategoryService } from 'src/app/modules/settings/category/services/category.service';
import { OrganizationService } from '../../services/organization.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    organizationWork: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(50)]],
    fullname: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    type: ['STUDENT'],
    dateOfBirth: [null, [ValidationService.required]],
    address: [null],
    gender: [1, [ValidationService.required]],
    ethnic: [null],
    isPartyMember: [0],
    partyDate: [null],
    phoneNumber: [null],
  };
  formSave: FormGroup;
  // Diện đối tượng
  objTypeOptions = OBJ_TYPE_OPTIONS;
  // Ngoài học viện
  isOutsideOptions = [
    { label: "Trong HV", value: 0 },
    { label: "Ngoài HV", value: 1 }
  ]
  // Đảng viên
  isPartyMemberOptions = [
    { label: "Chưa vào Đảng", value: 0 },
    { label: "Đã vào Đảng", value: 1 }
  ]

  statusDefenceSecurityOptions = STATUS_DEFENCE_SECURITY;

  genderOptions = GENDER_OPTIONS;
  employeeId: any;
  constructor(
    public _injector: Injector,
    public translate: L10nTranslationService,
    public empService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    public categoryService: CategoryService,
    public orgService: OrganizationService,

  ) {
    super(_injector, route, RESOURCE.EMPLOYEE, ACTION_FORM.INSERT);
    this.formSave = this.buildForm({}, this.formConfig);
  }

  ngOnInit() {
    this.employeeId = this.route.snapshot.paramMap.get('id');
    if (!!this.employeeId) {
      this.empService.findOne(this.employeeId).subscribe(res => {
        this.formSave = this.buildForm(res.data, this.formConfig);
      })
    }
  }

  get f() {
    return this.formSave.controls;
  }

  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.empService.saveOrUpdate(this.formSave.value)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.onCancel();
          }
        });
    }, () => {// on rejected
    });
  }

  onCancel() {
    this.router.navigate(['/bien-che-to-chuc/ho-so']);
  }
}
