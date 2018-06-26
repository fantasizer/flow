export interface IDepartment {
    id?: any;
    orderNo?: number;
    parentId?: number;
    parentIds?: string;
    simpleName?: string;
    fullName?: string;
    tips?: boolean;
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
}

export class Department implements IDepartment {
    constructor(public id?: any,
                public orderNo?: number,
                public parentId?: number,
                public  parentIds?: string,
                public   simpleName?: string,
                public   fullName?: string,
                public    tips?: boolean,
                public   createdBy?: string,
                public    createdDate?: Date,
                public lastModifiedBy?: string,
                public   lastModifiedDate?: Date) {
        this.id = id ? id : null;
        this.orderNo = orderNo ? orderNo : 999;
        this.parentId = parentId ? parentId : -1;
        this.parentIds = parentIds ? parentIds : null;
        this.simpleName = simpleName ? simpleName : null;
        this.fullName = fullName ? fullName : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
