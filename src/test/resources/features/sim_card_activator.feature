Feature: Was the sim activation a success?




  Scenario: The activation WAS a success
    Given The iccid is "<1255789453849037777>"
    When I check if the sim card is activated
    Then It should succeed

  Scenario: The activation was NOT a success
    Given The iccid is "<8944500102198304826>"
    When I check if the sim card is activated
    Then It should fail