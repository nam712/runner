export const APP_CONSTANTS = {

}

export const CONFIG: any = {
    API_PATH: {
        home: '/v1/home',
        categoryType: '/v1/category-type',
        category: '/v1/category',
        organization: '/v1/organization',
        employee: '/v1/employee',
        educationType: '/v1/education-type',
        trainingCourse: '/v1/training-course',
        course: '/v1/course',
        classroom: '/v1/classroom',
        classroomSchedule: '/v1/classroom-schedule',
        employeeRequest: '/v1/employee-request',
        employeeClassroom: '/v1/employee-classroom',
        employeeClassroomAttend: '/v1/employee-classroom-attend',
        certificateApproval: '/v1/certificate-approval',
        certificateBook: '/v1/certificate-book',
        role: '/v1/role',
        resource: '/v1/resource',
        user: '/v1/user',
        auth: '/v1/auth',
        student: '/v1/student',
        roomType: '/v1/room-type',
        room: '/v1/room',
        contract: '/v1/contract',
        waterElectric: '/v1/water-electric',
        waterElectricBill: '/v1/water-electric-bill',
    }
};

export const PERMISSION_CODE: any = {
    // action tac dong
    'action.view': 'VIEW'
    , 'action.insert': 'INSERT'
    , 'action.update': 'UPDATE'
    , 'action.delete': 'DELETE'
    , 'action.import': 'IMPORT'
    , 'action.export': 'EXPORT'
    , 'action.approve': 'APPROVE'
    , 'action.decide': 'DECIDE'
    , 'action.unDecide': 'UN_DECIDE'
    , 'action.unApproveAll': 'UN_APPROVE_ALL'
    , 'action.approveAll': 'APPROVE_ALL'
    , 'action.removeEmp': 'REMOVE_EMP'
    , 'action.addEmp': 'ADD_EMP'
    , 'action.unApprove': 'UN_APPROVE'
    , 'action.unLock': 'UN_LOCK'
    , 'action.lock': 'LOCK'
    , 'action.calculate': 'CALCULATE'
    , 'action.viewHistory': 'VIEW_HISTORY'
    , 'action.enable': 'ENABLE'
    , 'action.disable': 'DISABLE'
    , 'action.issueAgain': 'ISSUE_AGAIN'
    , 'action.issueChange': 'ISSUE_CHANGE'
    , 'action.quickImport': 'QUICK_IMPORT'
    , 'action.transfer': 'TRANSFER'
    , 'action.manage': 'MANAGE'
    , 'action.viewAll': 'VIEW_ALL'
    , 'action.payrollCalculate': 'PAYROLL_CALCULATE'
    , 'action.payrollDestroy': 'DESTROY_PAYROLL'
    , 'action.syncTax': 'SYNC_TAX'
    , 'action.syncPayroll': 'SYNC_PAYROLL'
    , 'action.addAction': 'ADD_ACTION'
    , 'action.grantRole': 'GRANT_ROLE'
    , 'action.grantMenu': 'GRANT_MENU'
    , 'action.grantPermission': 'GRANT_PERMISSION'
    , 'action.updateStatus': 'UPDATE_STATUS'
    , 'action.resetPassword': 'RESET_PASSWORD'
    , 'action.lockUser': 'LOCK_USER'
    , 'action.brag': 'BRAG' // Dồn túi & làm phách
    , 'action.dataSynthesis': 'DATA_SYNTHESIS' // Tổng hợp dữ liệu
    , 'action.mngStudent': 'MNG_STUDENT' // Tổng hợp dữ liệu


    , 'resource.organization': 'ORGANIZATION'
    , 'resource.employee': 'EMPLOYEE'
    , 'resource.trainingCourse': 'TRAINING_COURSE'
    , 'resource.educationType': 'EDUCATION_TYPE'
    , 'resource.category': 'CATEGORY'
    , 'resource.employeeRequest': 'EMPLOYEE_REQUEST'
    , 'resource.employeeClassroom': 'EMPLOYEE_CLASSROOM'
    , 'resource.employeeClassroomAttend': 'EMPLOYEE_CLASSROOM_ATTEND'
    , 'resource.course': 'COURSE'
    , 'resource.classroom': 'CLASSROOM'
    , 'resource.classroomSchedule': 'CLASSROOM_SCHEDULE'
    , 'resource.gradingAssignments': 'GRADING_ASSIGNMENTS' // Chấm bài thu hoạch
    , 'resource.certificateApproval': 'CERTIFICATE_APPROVAL' // Xét duyệt cấp chứng chỉ
    , 'resource.certificateBook': 'CERTIFICATE_BOOK' // Sổ cấp chứng chỉ
    , 'resource.role': 'ROLE'
    , 'resource.user': 'USER'
    , 'resource.roomType': 'ROOM_TYPE'
    , 'resource.subject': 'SUBJECT'
    , 'resource.schoolYear': 'SCHOOL_YEAR'
    , 'resource.classSubject': 'CLASS_SUBJECT'
};

export enum RESOURCE {
    HOME = 'HOME',
    OVERALL_STATISTICS = 'OVERALL_STATISTICS',
    SYS_PROPERTY = 'SYS_PROPERTY',
    SETTING = 'SETTING',
    CATEGORY_TYPE = 'CATEGORY_TYPE',
    CATEGORY = 'CATEGORY',
    // Tổ chức - bộ máy, biên chế
    MNG_ORGANIZATION = 'MNG_ORGANIZATION',
    ORGANIZATION = 'ORGANIZATION',
    EMPLOYEE = 'EMPLOYEE',
    EDUCATION_TYPE = 'EDUCATION_TYPE',
    TRAINING_COURSE = 'TRAINING_COURSE',
    COURSE = 'COURSE',
    CLASSROOM = 'CLASSROOM',
    ROLE = 'ROLE',
    USER = 'USER',
    AUTH = 'AUTH',
    STUDENT = 'STUDENT',
    ROOM_TYPE = 'ROOM_TYPE',
    ROOM = 'ROOM',
    CONTRACT = 'CONTRACT',
    WATER_ELECTRIC = 'WATER_ELECTRIC',
    WATER_ELECTRIC_BILL = 'WATER_ELECTRIC_BILL',
}

export enum INPUT_TYPE {
    TEXT = 'text',
    NUMBER = 'number',
    TEXT_AREA = 'text-area',
    CURRENCY = 'currency',
    DATE = 'date',
    URL = 'url',
    PASSWORD = 'password',
}

export enum ACTION_FORM {
    SEARCH = 'SEARCH',
    INSERT = 'INSERT',
    UPDATE = 'UPDATE',
    IMPORT = 'IMPORT',
    VIEW = 'VIEW',
    DELETE = 'DELETE',
    CONFIG = 'CONFIG',
    UPDATE_STATUS = 'UPDATE_STATUS',

    SYS_CAT_TYPE_INSERT = 'SYS_CAT_TYPE_INSERT'
}


export enum SEARCH_OPERATION {
    IN = 'in',
    GREATER_THAN = 'gt',
    LESS_THAN = 'lt',
    GREATER_THAN_EQUAL = 'gte',
    LESS_THAN_EQUAL = 'lte',
    NOT_EQUAL = 'neq',
    EQUAL = 'eq',
    MATCH = 'ma',
    MATCH_END = 'mae',
}

export const GENDER_OPTIONS = [
    { label: "Nam", value: 1 },
    { label: "Nữ", value: 0 },
]
export const OBJ_TYPE_OPTIONS = [
    { label: "Cán bộ", value: "OFFICERS" },
    { label: "Học viên", value: "STUDENT" }
]

export const STATUS_DEFENCE_SECURITY = [
    { label: "Chưa học", value: 0 },
    { label: "Đã học", value: 1 },
    { label: "Chưa đủ điều kiện", value: 2 },
    { label: "Đã đăng ký học", value: 3 },
]


export enum CLASSROOM_STATUS_ENUM {
    TAO_MOI = 'TAO_MOI',
    DANG_HOC = 'DANG_HOC',
    DA_THAM_QUAN = 'DA_THAM_QUAN',
    DA_THI = 'DA_THI',
    DA_KET_THUC = 'DA_KET_THUC',
}
export const CLASSROOM_STATUS = [
    { label: "Tạo mới", value: CLASSROOM_STATUS_ENUM.TAO_MOI },
    { label: "Đang học", value: CLASSROOM_STATUS_ENUM.DANG_HOC },
    { label: "Đã đi tham quan", value: CLASSROOM_STATUS_ENUM.DA_THAM_QUAN },
    { label: "Đã thi", value: CLASSROOM_STATUS_ENUM.DA_THI },
    { label: "Đã kết thúc", value: CLASSROOM_STATUS_ENUM.DA_KET_THUC },
]
export enum CLASSROOM_SCHEDULE_TYPE_ENUM {
    LY_THUYET = 'LY_THUYET',
    THAM_QUAN = 'THAM_QUAN',
    THI = 'THI',
}

export const CLASSROOM_SCHEDULE_TYPE = [
    { label: "Lý thuyết", value: CLASSROOM_SCHEDULE_TYPE_ENUM.LY_THUYET },
    { label: "Tham quan", value: CLASSROOM_SCHEDULE_TYPE_ENUM.THAM_QUAN },
    { label: "Thi", value: CLASSROOM_SCHEDULE_TYPE_ENUM.THI },
]