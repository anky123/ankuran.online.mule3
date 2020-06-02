%dw 1.0
%output application/csv
---
payload.employees map ((employee , indexOfEmployee) -> {
	"FullName": employee.firstName
++ " " ++ employee.lastName,
	Email: employee.email,
	Salary: employee.salary,
	Married: employee.married as :string
})