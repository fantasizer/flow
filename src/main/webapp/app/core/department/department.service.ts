import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDepartment } from './department.model';

@Injectable({ providedIn: 'root' })
export class DepartmentService {
    private resourceUrl = SERVER_API_URL + 'department/list';

    private createURL= SERVER_API_URL + 'department/add';

    private updateURL = SERVER_API_URL + 'department/update';

    constructor(private http: HttpClient) {}

    create(department: IDepartment): Observable<HttpResponse<IDepartment>> {
        return this.http.post<IDepartment>(this.createURL, department, { observe: 'response' });
    }

    update(department: IDepartment): Observable<HttpResponse<IDepartment>> {
        return this.http.put<IDepartment>(this.updateURL, department, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<IDepartment[]>> {
        const options = createRequestOption(req);
        return this.http.get<IDepartment[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

}
