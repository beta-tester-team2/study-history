-- 1. 부서코드가 노옹철 사원과 같은 소속의 직원 명단 조회하세요.
SELECT `EMP_NAME`
FROM `EMPLOYEE`
WHERE `DEPT_CODE` = (SELECT `DEPT_CODE` FROM `EMPLOYEE` WHERE `EMP_NAME` = '노옹철')

-- 2. 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
SELECT `EMP_ID`, `EMP_NAME`, `JOB_CODE`, `SALARY`
FROM `EMPLOYEE`
WHERE `SALARY` > (SELECT AVG(`SALARY`) FROM `EMPLOYEE`)

-- 3. 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여를 조회하세요.
SELECT `EMP_ID`, `EMP_NAME`, `DEPT_CODE`, `JOB_CODE`, `SALARY`
FROM `EMPLOYEE`
WHERE `SALARY` > (SELECT `SALARY` FROM `EMPLOYEE` WHERE `EMP_NAME` = '노옹철')

-- 4. 가장 적은 급여를 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여, 입사일을 조회하세요.
SELECT `EMP_ID`, `EMP_NAME`, `DEPT_CODE`, `JOB_CODE`, `SALARY`, `HIRE_DATE`
FROM `EMPLOYEE`
WHERE `SALARY` = (SELECT MIN(`SALARY`) FROM `EMPLOYEE`)

-- *** 서브쿼리는 SELECT, FROM, WHERE, HAVING, ORDER BY절에도 사용할 수 있다.

-- 5. 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회하세요.
-- 부서코드가 NULL인 부서 제외 (WHERE 서브쿼리)
SELECT `EMP_NAME`, `JOB_CODE`, `DEPT_CODE`, `SALARY`
FROM `EMPLOYEE`
WHERE
    (`DEPT_CODE`, `SALARY`) IN
    (SELECT `DEPT_CODE`, MAX(`SALARY`) FROM `EMPLOYEE` GROUP BY `DEPT_CODE`)

-- 부서코드가 NULL인 부서 제외 (FROM 서브쿼리)
SELECT e.`EMP_NAME`, e.`JOB_CODE`, e.`DEPT_CODE`, e.`SALARY`
FROM 
    `EMPLOYEE` e JOIN
        (SELECT `DEPT_CODE`, MAX(`SALARY`) `MAX_SALARY` FROM `EMPLOYEE` GROUP BY `DEPT_CODE`) tmp
        ON e.`DEPT_CODE` = tmp.`DEPT_CODE` AND e.`SALARY` = tmp.`MAX_SALARY`

-- 부서코드가 NULL인 부서 포함 (UNION ALL)
-- DEPT_CODE가 NULL인것과 아닌것을 구하고 UNION ALL
SELECT `EMP_NAME`, `JOB_CODE`, `DEPT_CODE`, `SALARY`
FROM `EMPLOYEE`
WHERE 
    (`DEPT_CODE`, `SALARY`) IN
    (SELECT `DEPT_CODE`, MAX(`SALARY`) FROM `EMPLOYEE` GROUP BY `DEPT_CODE`)
UNION ALL
SELECT `EMP_NAME`, `JOB_CODE`, `DEPT_CODE`, `SALARY`
FROM `EMPLOYEE`
WHERE
    `DEPT_CODE` IS NULL AND
    `SALARY` = (SELECT MAX(`SALARY`) FROM `EMPLOYEE` WHERE `DEPT_CODE` IS NULL)

-- *** 여기서부터 난이도 극상

-- 6. 관리자에 해당하는 직원에 대한 정보와 관리자가 아닌 직원의 정보를 추출하여 조회하세요.
-- 사번, 이름, 부서명, 직급, '관리자' AS 구분 / '직원' AS 구분
-- HINT!! is not null, union(혹은 then, else), distinct
-- (CASE - THEN - ELSE)를 사용한 방법, 관리자인지, 직원인지 여부는 필드 하나에만 한정되기 때문에 가능!
SELECT
    e.`EMP_ID`, e.`EMP_NAME`, d.`DEPT_TITLE`, j.`JOB_NAME`,
    CASE 
        WHEN `EMP_ID` IN (SELECT DISTINCT `MANAGER_ID` FROM `EMPLOYEE`)
        THEN '관리자'
        ELSE '직원' 
    END AS '구분'
FROM
    `EMPLOYEE` e 
    LEFT JOIN `DEPARTMENT` d ON e.`DEPT_CODE` = d.`DEPT_ID`
    LEFT JOIN `JOB` j ON e.`JOB_CODE` = j.`JOB_CODE`

-- UNION을 사용한 방법, 관리자 사번에 포함된 사원과 포함되지 않은 사원을 구하고 UNION
SELECT
    e.`EMP_ID`, e.`EMP_NAME`, d.`DEPT_TITLE`, j.`JOB_NAME`, '관리자' AS '구분'
FROM
    `EMPLOYEE` e
    LEFT JOIN `DEPARTMENT` d ON e.`DEPT_CODE` = d.`DEPT_ID`
    LEFT JOIN `JOB` j ON e.`JOB_CODE` = j.`JOB_CODE`
WHERE
    `EMP_ID` IN
    (SELECT DISTINCT `MANAGER_ID` FROM `EMPLOYEE` WHERE `MANAGER_ID` IS NOT NULL)
UNION
SELECT
    e.`EMP_ID`, e.`EMP_NAME`, d.`DEPT_TITLE`, j.`JOB_NAME`, '직원' AS '구분'
FROM
    `EMPLOYEE` e
    LEFT JOIN `DEPARTMENT` d ON e.`DEPT_CODE` = d.`DEPT_ID`
    LEFT JOIN `JOB` j ON e.`JOB_CODE` = j.`JOB_CODE`
WHERE
    `EMP_ID` NOT IN
    (SELECT `MANAGER_ID` FROM `EMPLOYEE` WHERE `MANAGER_ID` IS NOT NULL)

-- 7. 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
-- 단, 급여와 급여 평균은 만원단위로 계산하세요.
-- HINT!! round(컬럼명, -5)
-- 만원단위, 급여와 급여 평균에 대해 ROUND처리.
SELECT `EMP_ID`, `EMP_NAME`, `JOB_CODE`, ROUND(`SALARY`, -5)
FROM `EMPLOYEE` e
WHERE (e.`JOB_CODE`, ROUND(e.`SALARY`, -5)) = (
    SELECT sub.`JOB_CODE`, ROUND(AVG(ROUND(`SALARY`, -5)), -5)
    FROM `EMPLOYEE` sub
    WHERE e.`JOB_CODE` = sub.`JOB_CODE`
)

-- 7번 데이터 테스트 (임시)
SELECT `JOB_CODE`, ROUND(AVG(ROUND(`SALARY`, -5)), -5) FROM `EMPLOYEE` GROUP BY `JOB_CODE`

-- 8. 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 직원의 이름, 직급코드, 부서코드, 입사일을 조회하세요.
SELECT `EMP_NAME`, `JOB_CODE`, `DEPT_CODE`, `HIRE_DATE`
FROM `EMPLOYEE`
WHERE (`DEPT_CODE`, `JOB_CODE`) IN (
    SELECT `DEPT_CODE`, `JOB_CODE`
    FROM `EMPLOYEE`
    WHERE
        `ENT_YN` = 'Y' AND /* 퇴사여부 */
        SUBSTR(`EMP_NO`, 8, 1) IN ('2', '4') /* 주민번호 기준 성별 */
) AND `EMP_NAME` != (
    /* 본인 제외 */
    SELECT `EMP_NAME`
    FROM `EMPLOYEE`
    WHERE
        `ENT_YN` = 'Y' AND /* 퇴사여부 */
        SUBSTR(`EMP_NO`, 8, 1) IN ('2', '4') /* 주민번호 기준 성별 */
)

-- 9. 급여 평균 3위 안에 드는 부서의 부서 코드와 부서명, 평균급여를 조회하세요.
-- HINT!! limit
SELECT e.`DEPT_CODE`, d.`DEPT_TITLE`, AVG(e.`SALARY`) AS '평균급여'
FROM
    `EMPLOYEE` e
    LEFT JOIN `DEPARTMENT` d ON e.`DEPT_CODE` = d.`DEPT_ID`
GROUP BY e.`DEPT_CODE`
ORDER BY AVG(e.`SALARY`) DESC
LIMIT 3

-- 10. 부서별 급여 합계가 전체 급여의 총 합의 20%보다 많은 부서의 부서명과, 부서별 급여 합계를 조회하세요.
-- '부서별' 급여 합계를 구하는 문제입니다, 따라서 HAVING을 사용합니다.
SELECT d.`DEPT_TITLE`, SUM(e.`SALARY`)
FROM
    `EMPLOYEE` e
    LEFT JOIN `DEPARTMENT` d ON e.`DEPT_CODE` = d.`DEPT_ID`
GROUP BY e.`DEPT_CODE`
HAVING 
    SUM(e.`SALARY`) > (SELECT SUM(`SALARY`) * 0.2 FROM `EMPLOYEE`)