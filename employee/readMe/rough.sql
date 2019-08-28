SELECT
    emp.emp_id               AS emp_id,
    emp.first_name           AS emp_first_name,
    emp.last_name            AS emp_last_name,
    emp.gender               AS emp_gender,
    emp.birth_date           AS emp_birth_date,
    emp.hire_date            AS emp_hire_date,
    emp.version              AS emp_version,
    emp.last_modified_date   AS emp_last_modified_date,
    dept.dept_id             AS dept_id,
    dept.name                AS dept_name,
    dept.version             AS dept_version,
    dept.last_modified_date    AS dept_last_modified_date
FROM
    emp    emp
    LEFT JOIN dept   dept ON emp.dept_id = dept.dept_id
WHERE
    1 = 1
    AND emp_id = 1