import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { RouterModule } from '@angular/router';
import {
    entityState,
    DepartmentMgmtComponent
} from './';

@NgModule({
    imports: [
        RouterModule.forChild(entityState)
    ],
    declarations: [
        DepartmentMgmtComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FlowEntityModule {}
