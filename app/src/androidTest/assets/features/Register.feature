Feature: 註冊

  註冊會員的檢查：
  帳號(至少6碼，第1碼為英文)
  密碼(至少8碼，第1碼為英文，並包含1碼數字)
  若登入失敗應Alert提醒，登入成功則開啟至登入成功頁面。

  @register
  Scenario: 註冊成功
    Given 我開啟註冊頁面
    When 我在帳號輸入 a123456789
    And 我在密碼輸入 a222222222
    And 點擊註冊按鈕
    Then 我會看到註冊成功的畫面

  @register
  Scenario Outline: 註冊失敗
    Given 我開啟註冊頁面
    When 我在帳號輸入 <LoginId>
    And 我在密碼輸入 <Password>
    And 點擊註冊按鈕
    Then 我會看到註冊失敗的提醒

    Examples:
      | LoginId | Password |
      | 111111  | 222222   |
      | aaa     | bbb      |
