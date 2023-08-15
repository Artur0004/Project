Feature: Choosing Magic Class
  Scenario: User should be able to choose its own stats
    Given The user is asked about stats
    Then The user has chosen its desired stats

  Scenario: User should be able to choose spell to cast
    Given The user is asked about spell
    Then The user has chosen its desired spell

  Scenario: User should be able to see its own health and mana points
    Given The user wants to see own health and mana points
    Then The user sees own health and mana points



