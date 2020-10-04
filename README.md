# Spring_boot_api

src\main\resources
  裡面是執行專案時會執行的sql指令，schema.sql 建立相對應表，data匯入預設資料
  
src\main\java\com\example\demo
  裡面是程式碼
    Controller 定義API路徑，分別是 /department/... 和 /employee/.... ，以restful形式定義API，以json物件方式回傳
    
    Service 是實際進行查DB等功能的地方
    


src\test\java\com\example\demo
  裡面是測試程式，分別測試Service 的新增、刪除、修改與多條件查詢員工資料
