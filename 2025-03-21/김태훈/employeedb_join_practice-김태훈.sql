-- JOIN을 이용하여 여러 테이블을 조회 시에는 모든 컬럼에 테이블 별칭을 사용하는 것이 좋다.
select * from DEPARTMENT;
select * from JOB;
select * from LOCATION;
select * from NATION;
select * from SAL_GRADE;
select * from EMPLOYEE;
-- 1. 직급이 대리이면서 아시아 지역에 근무하는 직원의 사번, 이름, 직급명, 부서명, 지역명, 급여를 조회하세요
select e.EMP_ID, e.EMP_NAME, j.JOB_NAME, d.DEPT_TITLE, l.LOCAL_NAME, e.SALARY
from EMPLOYEE e inner join JOB j on j.JOB_CODE = e.JOB_CODE
				inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
                inner join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
where j.JOB_CODE = 'J6' and l.LOCAL_CODE in ('L1', 'L2', 'L3');
-- 2. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 전씨인 직원의 이름, 주민등록번호, 부서명, 직급명을 조회하세요.
select e.EMP_NAME, e.EMP_NO, d.DEPT_TITLE, j.JOB_NAME
from EMPLOYEE e inner join JOB j on j.JOB_CODE = e.JOB_CODE
				inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
where e.EMP_NO like '7%' and e.EMP_NO like '%-2%' and e.EMP_NAME like '전%';
-- 3. 이름에 '형'자가 들어가는 직원의 사번, 이름, 직급명을 조회하세요.
select e.EMP_ID, e.EMP_NAME, j.JOB_NAME
from EMPLOYEE e inner join JOB j on j.JOB_CODE = e.JOB_CODE
where e.EMP_NAME like '%형%';
-- 4. 해외영업팀에 근무하는 직원의 이름, 직급명, 부서코드, 부서명을 조회하세요.
select e.EMP_NAME, j.JOB_NAME, d.DEPT_ID, d.DEPT_TITLE
from EMPLOYEE e inner join JOB j on j.JOB_CODE = e.JOB_CODE
				inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
where d.DEPT_ID in ('D5','D6','D7');
-- 5. 보너스포인트를 받는 직원의 이름, 보너스, 부서명, 지역명을 조회하세요.
select e.EMP_NAME, e.BONUS, d.DEPT_TITLE, l.LOCAL_NAME
from EMPLOYEE e inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
				inner join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
where e.BONUS is not null;
-- 6. 부서코드가 D2인 직원의 이름, 직급명, 부서명, 지역명을 조회하세오.
select e.EMP_NAME, j.JOB_NAME, d.DEPT_TITLE, l.LOCAL_NAME
from EMPLOYEE e inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
				inner join JOB j on j.JOB_CODE = e.JOB_CODE
				inner join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
where e.DEPT_CODE = 'D2';
-- 7. 한국(KO)과 일본(JP)에 근무하는 직원의 이름, 부서명, 지역명, 국가명을 조회하세요.
select e.EMP_NAME, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
from EMPLOYEE e inner join DEPARTMENT d on d.DEPT_ID = e.DEPT_CODE
				inner join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
                inner join NATION n on l.NATIONAL_CODE = n.NATIONAL_CODE
where l.NATIONAL_CODE in ('KO','JP');