import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { RouterModule } from '@angular/router';
import {
    entityState,
    DepartmentMgmtComponent,
    DepartmentMgmtDeleteDialogComponent,
    DepartmentMgmtDetailComponent,
    DepartmentUpdateComponent,
} from './';

@NgModule({
    imports: [
        RouterModule.forChild(entityState)
    ],
    declarations: [
        DepartmentMgmtComponent,
        DepartmentMgmtDeleteDialogComponent,
        DepartmentMgmtDetailComponent,
        DepartmentUpdateComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FlowEntityModule {}
