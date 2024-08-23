### 1. App06-1
#### 1. MainActivity
> : RecyclerView 의 데이터 추가, 수정, 삭제를 Adapter class 에서 구현
<details>
  <summary>class</summary>
  
+ ##### <mark>Phone</mark>
  > name, tel 저장하는 data class
  
+ ##### <mark>PhoneAdapter</mark>
  > MainActivity 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
  + addItem(아이템 추가)
    > 'phoneList' 데이터 추가
  + updateItem(아이템 수정)
    > 'phoneList' 특정 데이터 수정
  + deleteItem(아이템 삭제)
    > 'phoneList' 특정 데이터 삭제
  + OnItemClickLister Interface
    > RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
  + itemView.setOnClickListener
    > RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>


#### 2. MainActivity2
> : RecyclerView 의 데이터 추가, 수정, 삭제를 MainActivity2 에서 구현
<details>
  <summary>class</summary>

+ ##### <mark>Friend</mark>
  > resourceId, name, msg 저장하는 data class
  
+ ##### <mark>FriendAdapter</mark>
  > MainActivity2 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
  + OnItemClickLister Interface
    > RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
  + itemView.setOnClickListener
    > RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>

<br>

### 2. App06-2
> App06-3 에서 다시 시작

<br>
<br>

## 3. App06-3
