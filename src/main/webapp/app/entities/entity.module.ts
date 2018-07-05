import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {
    entityState,
    DepartmentMgmtComponent,
    DepartmentUpdateComponent
} from './';

@NgModule({
    imports: [
        RouterModule.forChild(entityState),
        FormsModule
    ],
    declarations: [
        DepartmentMgmtComponent,
        DepartmentUpdateComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FlowEntityModule {}
