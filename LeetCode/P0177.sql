CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N-1;
  RETURN (
    SELECT DISTINCT(SALARY) 
    FROM EMPLOYEE
    ORDER BY SALARY DESC
    LIMIT N, 1      
  );
END