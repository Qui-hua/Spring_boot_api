# Spring_boot_api

src\main\resources
  裡面是執行專案時會執行的sql指令，schema.sql 建立相對應表，data匯入預設資料
  
src\main\java\com\example\demo
  裡面是程式碼
    Controller 定義API路徑，分別是 /department/... 和 /employee/.... ，以restful形式定義API，以json物件方式回傳
      find每頁最多10筆資料，可對員工編號、員工姓名、員工所屬部門姓名、員工年紀進行多條件篩選，如多條件時，是以多條件都是成立下進行搜尋。
      新增、修改的時候 state會標記對應狀態或錯誤形況
    
    Service 是實際進行查DB等功能的地方
    
    
    


src\test\java\com\example\demo
  裡面是測試程式，分別測試Service 的新增、刪除、修改與多條件查詢員工資料
