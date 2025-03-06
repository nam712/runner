import { Component, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';

@Component({
  selector: 'app-room-student',
  templateUrl: './room-student.component.html',
  styleUrls: ['./room-student.component.scss']
})
export class RoomStudentComponent extends BaseComponent {
  roomCode: any = {};
  studentList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomService: RoomService,
  ) {
    super(_injector);
    this.roomCode = config?.data?.roomCode;
    this.loadStudentList();
  }

  loadStudentList() {
    this.roomService.getRoomStudent(this.roomCode)
      .subscribe(res => {
        this.studentList = res?.data || [];
      });
  }
}
