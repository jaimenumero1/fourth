Feature: Add 200 employees to Database

  Scenario: Make sure Database works by stress testing it
    Given  you have a connection to the Database
    And you also have a table that you would like to iterate over and send to Database
    When you fill data base with Following table
      | employeeNumber | lastName  | firstName | extension | email                        | officeCode | reportsTo | jobTitle     |
      | 0              | Galveston | Sorin     | 1         | soringalveston@galveston.com | 101        | 222       | Scrum Master |
      | 0              | Lopez     | John      | 1         | jonnyboy@usa.com             | 223        | 2223      | Actor        |
      | 0              | Musk      | Elon      | 2         | musk@Tesla.com               | 100        | 1         | Entrepreneur |
      | 0              | Brownson  | Charles   | 1         | brown@fighter.com            | 777        | 77        | Actor        |
      | 0              | Sofia     | Urea      | 3         | sofia@integration.com        | 333        | 69        | Engineer     |
    Then database should be full

  Scenario: Test query method with one question mark
    When the following query "SELECT * FROM employees WHERE lastName = ?;" is executed with "Lopez" as lastname
    Then make sure the resultSet is accurate


  Scenario: test with more multiple question marks
    When query "SELECT * FROM employees WHERE lastName = ? ? ? ;" inserts "Musk"  "Urea"  "Lopez" is provided
    Then make sure the multiple resultSet is accurate