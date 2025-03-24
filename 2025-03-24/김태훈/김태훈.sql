use employeedb;
select * from DEPARTMENT;
select * from EMPLOYEE;
select * from JOB;
select * from LOCATION;
select * from NATION;
select * from SAL_GRADE;

-- 1. 부서코드가 노옹철 사원과 같은 소속의 직원 명단 조회하세요.
select EMP_NAME from EMPLOYEE
where DEPT_CODE = (select DEPT_CODE from EMPLOYEE where EMP_NAME = '노옹철');
-- 2. 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
select EMP_ID, EMP_NAME, JOB_CODE, SALARY
from EMPLOYEE
where SALARY > (select avg(SALARY) from EMPLOYEE);
-- 3. 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여를 조회하세요.
select EMP_ID, EMP_NAME, JOB_CODE, SALARY
from EMPLOYEE
where SALARY > (select SALARY from EMPLOYEE where EMP_NAME = '노옹철');
-- 4. 가장 적은 급여를 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여, 입사일을 조회하세요.
select EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE
from EMPLOYEE
where SALARY = (select min(SALARY) from EMPLOYEE);
-- *** 서브쿼리는 SELECT, FROM, WHERE, HAVING, ORDER BY절에도 사용할 수 있다.

-- 5. 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회하세요.
select EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
from EMPLOYEE
where (DEPT_CODE, SALARY) in (select DEPT_CODE ,max(SALARY) from EMPLOYEE group by DEPT_CODE);
-- *** 여기서부터 난이도 극상

-- 6. 관리자에 해당하는 직원에 대한 정보와 관리자가 아닌 직원의 정보를 추출하여 조회하세요.
-- 사번, 이름, 부서명, 직급, '관리자' AS 구분 / '직원' AS 구분
-- HINT!! is not null, union(혹은 then, else), distinct
select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME,
case
when e.MANAGER_ID is not null then '관리자'
else '직원'
end as 구분
from EMPLOYEE e
join DEPARTMENT d on e.DEPT_CODE = d.DEPT_ID
join JOB j on e.JOB_CODE = j.JOB_CODE;

-- 7. 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
-- 단, 급여와 급여 평균은 만원단위로 계산하세요.
-- HINT!! round(컬럼명, -5)
select e.EMP_ID, e.EMP_NAME, e.JOB_CODE, round(e.SALARY, -5) as SALARY
from EMPLOYEE e
where round(e.SALARY, -5) = (select round(avg(SALARY), -5)
from EMPLOYEE e2
where e.JOB_CODE = e2.JOB_CODE);

-- 8. 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 직원의 이름, 직급코드, 부서코드, 입사일을 조회하세요.
select EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
from EMPLOYEE
where (DEPT_CODE, JOB_CODE) = (select DEPT_CODE, JOB_CODE
from EMPLOYEE
where ENT_DATE is not null);
-- 9. 급여 평균 3위 안에 드는 부서의 부서 코드와 부서명, 평균급여를 조회하세요.
-- HINT!! limit
select e.DEPT_CODE, d.DEPT_TITLE, round(avg(e.SALARY), -4)
from EMPLOYEE e
join DEPARTMENT d on e.DEPT_CODE = d.DEPT_ID
group by e.DEPT_CODE, d.DEPT_TITLE
order by avg(e.SALARY) desc
limit 3;
-- 10. 부서별 급여 합계가 전체 급여의 총 합의 20%보다 많은 부서의 부서명과, 부서별 급여 합계를 조회하세요.
select d.DEPT_TITLE, round(sum(e.SALARY), -4)
from EMPLOYEE e
join DEPARTMENT d on e.DEPT_CODE = d.DEPT_ID
group by d.DEPT_TITLE
having sum(e.SALARY) > (select sum(SALARY) * 0.2 from EMPLOYEE);