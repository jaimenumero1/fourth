Feature: test test class

#  Background:
#    Given a connection to a database is started
## 2 lines above where not needed Before hooks and After hooks are working adjusted openMethod and then adjusted
## imports for the hooks to apply to Cucumber Feature files then imports must come from Cucumber  (NOT Junit).
  Scenario: Empty a table from a database
    When you remove all records from a "employees" table
    Then employees table should be empty


  Scenario: Fill employee table with table
    When you add records from the table below
  ##{"employeeNumber","lastName","firstName","extension","email","officeCode",
  #        "reportsTo","jobTitle"};
      | employeeNumber | lastName  | firstName | extension | email                        | officeCode | reportsTo | jobTitle     |
      | 11             | Galveston | Sorin     | 1         | soringalveston@galveston.com | 101        | 222       | Scrum Master |
      | 12             | Lopez     | John      | 1         | jonnyboy@usa.com             | 223        | 2223      | Actor        |
      | 13             | Musk      | Elon      | 2         | musk@Tesla.com               | 100        | 1         | Entrepreneur |
      | 14             | Brownson  | Charles   | 1         | brown@fighter.com            | 777        | 77        | Actor        |
      | 15             | Sofia     | Urea      | 3         | sofia@integration.com        | 333        | 69        | Engineer     |
    Then verify that the database has the following information
      | employeeNumber | lastName  | firstName | extension | email                        | officeCode | reportsTo | jobTitle     |
      | 11             | Galveston | Sorin     | 1         | soringalveston@galveston.com | 101        | 222       | Scrum Master |
      | 12             | Lopez     | John      | 1         | jonnyboy@usa.com             | 223        | 2223      | Actor        |
      | 13             | Musk      | Elon      | 2         | musk@Tesla.com               | 100        | 1         | Entrepreneur |
      | 14             | Brownson  | Charles   | 1         | brown@fighter.com            | 777        | 77        | Actor        |
      | 15             | Sofia     | Urea      | 3         | sofia@integration.com        | 333        | 69        | Engineer     |

  Scenario Outline: Be able to update a row in the database
    When employee <firstName> and <lastName> changes email, change to new <email>
    Then database should match new Updated <email>
    Examples:
      | firstName | lastName  | email                  |
      | Sorin     | Galveston | Sorinnuber1@yahoo.com  |
      | John      | Lopez     | johnDeveloper@java.com |
      | Charles   | Brownson  | charles@123.com        |
