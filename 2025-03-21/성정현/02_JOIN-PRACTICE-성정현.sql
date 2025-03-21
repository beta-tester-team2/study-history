use employee
-- JOIN을 이용하여 여러 테이블을 조회 시에는 모든 컬럼에 테이블 별칭을 사용하는 것이 좋다.

-- 1. 직급이 대리이면서 아시아 지역에 근무하는 직원의 사번, 이름, 직급명, 부서명, 지역명, 급여를 조회하세요
SELECT 
    e.emp_id,
    e.emp_name,
    j.job_name,
    d.dept_title,
    l.local_name,
    e.salary
FROM employee e
JOIN job j ON e.job_code = j.job_code
JOIN department d ON e.dpet_code = d.dpet_id
JOIN location l ON d.location_id = l.local_code
WHERE j.job_name = '대리'
AND l.local_name LIKE 'ASIA%';

SELECT 
    e.emp_id,
    e.emp_name,
    j.job_name,
    d.dept_title,
    l.local_name,
    e.salary
FROM employee e
JOIN job j ON e.job_code = j.job_code
JOIN department d ON e.dept_code = d.dept_id
JOIN location l ON d.location_id = l.local_code
WHERE j.job_name = '대리'
AND l.local_name LIKE 'ASIA%';

-- 2. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 전씨인 직원의 이름, 주민등록번호, 부서명, 직급명을 조회하세요.
SELECT 
    e.emp_name,
    e.emp_no,
    d.dept_title,
    j.job_name
FROM employee e
JOIN department d ON e.dept_code = d.dept_id
JOIN job j ON e.job_code = j.job_code
WHERE e.emp_no LIKE '7_____-2%'
AND e.emp_name LIKE '전%'

-- 3. 이름에 '형'자가 들어가는 직원의 사번, 이름, 직급명을 조회하세요.
SELECT 
    e.emp_id,
    e.emp_name,
    j.job_name
FROM employee e
JOIN job j ON e.job_code = j.job_code
WHERE e.emp_name LIKE '%형%';

-- 4. 해외영업팀에 근무하는 직원의 이름, 직급명, 부서코드, 부서명을 조회하세요.
SELECT 
    e.emp_name,
    j.job_name,
    e.dept_code,
    d.dept_title
FROM employee e
JOIN job j ON e.job_code = j.job_code
JOIN department d ON e.dept_code = d.dept_id
WHERE d.dept_title LIKE '해외영업%';

-- 5. 보너스포인트를 받는 직원의 이름, 보너스, 부서명, 지역명을 조회하세요.
SELECT 
    e.emp_name,
    e.bonus,
    d.dept_title,
    l.local_name
FROM employee e
JOIN department d ON e.dept_code = d.dept_id
JOIN location l ON d.location_id = l.local_code
WHERE e.bonus IS NOT NULL;

-- 6. 부서코드가 D2인 직원의 이름, 직급명, 부서명, 지역명을 조회하세오.
SELECT 
    e.emp_name,
    j.job_name,
    d.dept_title,
    l.local_name
FROM employee e
JOIN job j ON e.job_code = j.job_code
JOIN department d ON e.dept_code = d.dept_id
JOIN location l ON d.location_id = l.local_code
WHERE e.dept_code = 'D2';

-- 7. 한국(KO)과 일본(JP)에 근무하는 직원의 이름, 부서명, 지역명, 국가명을 조회하세요.
SELECT 
    e.emp_name,
    d.dept_title,
    l.local_name,
    n.national_name
FROM employee e
JOIN department d ON e.dept_code = d.dept_id
JOIN location l ON d.location_id = l.local_code
JOIN nation n ON l.national_code = n.national_code
WHERE n.national_code IN ('KO', 'JP');