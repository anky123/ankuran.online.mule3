%dw 1.0
%output application/java
---
payload.employees[0].firstName ++ " " ++ payload.employees[0].lastName