Feature: fpt shop system testcase
  @SmokeTest
  @UserSearchingProduct
  Scenario: User search product
    Given Navigate to Home page
    When User search product by key "iphone15"
    And User choose radio button "Sản phẩm cũ"
    And User choose list product has name "iPhone 15 128GB"
    Then User verify has "11" product on Result Search Page

  @SmokeTest
  @UserFilterProduct
  Scenario: User filter product on Mobile page
    Given Navigate to Home page
    When User choose " ĐIỆN THOẠI " on navbar
    And User choose some option filter
      | Hãng sản xuất  | Mức giá         | Loại điện thoại | Tính năng đặc biệt | Hiệu năng và Pin | Màn hình | Camera |
      | Apple (iPhone) | Từ 7 - 13 triệu | Tất cả          | Tất cả             | Tất cả           | Tất cả   | Tất cả |
    Then User verify has "2" product on Mobile Page

  @UserRatingProduct
  Scenario: User rating product
    Given Navigate to Home page
    When User search product by key "Xiaomi Redmi A3 4GB-128GB"
    And User choose product name "Xiaomi Redmi A3 4GB-128GB"
    And User click button Gửi đánh giá
    And User enter full information and click submit
      | Star | Comment                | Gender | Name   | Phone      | Email            |
      | 5    | Sản phẩm rất tuyệt vời | Boy    | Quan | 0979795656 | user12@gmail.com |
    Then User verify message success display

    @UerBuyProduct
    Scenario: User buy product
      Given Navigate to Home page
      When User search product by key "Xiaomi Redmi A3 4GB-128GB"
      And User choose product name "Xiaomi Redmi A3 4GB-128GB"
      And User click button buy now
      Then User verify number in cart.
      And User click user Voucher.
      And User click confirm
      And User enter infomation to receive and click completed
      Then User verify message completed display

    @UserCheckPrize
    Scenario: User check prize
      Given Navigate to Home page
      When User move "KHUYẾN MÃI" on navbar
      And User choose "Thông tin trao thưởng" in dropdown.
      And User enter phone "0979901956" and
