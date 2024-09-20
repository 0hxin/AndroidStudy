### 1. App04_intent
#### 1. Package sub
  > 사용자에게 숫자 두 개를 입력받아 더하기 연산 처리
<details>
  <summary>calss</summary>

  + ##### <mark>MainActivity</mark>
    + 사용자 입력 받아 MainAcitivitySub 에 숫자 전달

  + ##### <mark>MainActivitySub</mark>
    + 두 숫자 합계 계산하여 결과값 전달
</details>


#### 2. Package InputOutput
  > 사용자에게 이름, 나이, 전화번호 입력받아 출력
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + 사용자 입력 및 출력 다른 액티비티에서 처리

  + ##### <mark>MainActivity2_Input</mark>
    + 이름, 나이, 전화번호 입력받아 MainActivity2 로 반환

  + #### <mark>MainActivity2_Out</mark>
    + MainActivity2 에서 전달받은 이름, 나이, 전화번호 데이터 출력
</details>


#### 3. Package recycler
  > RecyclerView 데이터 출력
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2_recycler</mark>
    > RecyclerView 의 데이터 출력을 Adapter class 에서 구현
    
  + ##### <mark>MyAdapter</mark>
    > 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
</details>


#### 4. Package dialog
  > Dialog 결과값 처리
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity3</mark>
    + Dialog, CustomDialog 출력 및 사용자 선택 결과값 처리
</details>


#### 5. Package recyclerMemo
  > Recycler 데이터 출력
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity3_memo</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
  + ##### <mark>memo</mark>
    + no, title, timestamp 저장하는 data class
  + ##### <mark>CustomAdapter</mark>
    + 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
    + RecyclerView 데이터 선택 시, Toast 로 출력
</details>

<br>

### 2. App05
#### 1. Package dialog
  > Dialog
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + Dialog, CustomDialog 출력 및 사용자 선택 결과값 처리
</details>

#### 2. Package recycler
  > Recycler 데이터 출력
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2_recycler</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
  + ##### <mark>MyAdapter</mark>
    + 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
</details>

#### 3. Package memoRecycler
  > Recycler 데이터 출력
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity3_memo</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
  + ##### <mark>memo</mark>
    + no, title, timestamp 저장하는 data class
  + ##### <mark>CustomAdapter</mark>
    + 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
    + RecyclerView 데이터 클릭 -> Toast 로 출력
</details>

#### 4. Package movieRecycler
  > Recycler 데이터 출력 (이미지도 함께)
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity4_movie</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
  + ##### <mark>MovieItem</mark>
    + posterId, title 저장하는 data class
  + ##### <mark>MovieAdapter</mark>
    + 문자열과 이미지 리스트를 RecyclerView 에 표시하는 Adapter class
    + onBindViewHolder 함수를 MovieHolder 의 fun getItem 함수로 구현
</details>

#### 5. Package personRecycler
  > Recycler 데이터 출력 전체보기 버튼 추가 버튼 구현
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity5_person</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
    + 추가 버튼 클릭 시 Dialog 생성
  + ##### <mark>Person5</mark>
    + name, phone 저장하는 data class
  + ##### <mark>PersonAdapter</mark>
    + 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
    + RecyclerView 데이터 Click -> Toast 출력
    + RecyclerView 데이터 Long Click -> 삭제
</details>

<br>

### 3. App06-1
#### 1. Package phone
  > Recycler 데이터 출력 및 추가, 수정, 삭제
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + RecyclerView 의 데이터를 Adapter class 에서 구현
  + ##### <mark>Phone</mark>
    + name, tel 저장하는 data class
  + ##### <mark>PhoneAdapter</mark>
    + MainActivity 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
      + addItem(아이템 추가)
      + updateItem(아이템 수정)
      + deleteItem(아이템 삭제)
      + OnItemClickLister Interface
        + RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
      + itemView.setOnClickListener
        + RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>

#### 2. Package friend
  > Recycler 데이터 출력 및 추가, 수정, 삭제
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + RecyclerView 의 데이터 추가, 수정, 삭제를 MainActivity2 에서 구현
  + ##### <mark>Friend</mark>
    + resourceId, name, msg 저장하는 data class
  + ##### <mark>FriendAdapter</mark>
    + MainActivity2 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
      + OnItemClickLister Interface
        + RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
      + itemView.setOnClickListener
        + RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>

<br>

### ~~App06-2~~
### 4. App06-3
  > Open API Json 파싱
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + Retrofit 통해 Open API 호출하여 RecyclerView 에 출력
    + Photo, Post, Comment 버튼 이벤트
  + ##### <mark>JsonClient</mark>
    + Retrofit 인스턴스 생성
    + Retrofit 라이브러리 사용하여 Http 요청 처리
  + ##### <mark>JsonInterface</mark>
    + API 호출 정의
    + 'photos' 'posts' 'commets' 엔드포인트에 대한 GET 요청
  + ##### <mark>Photo / Post / Comment</mark>
    + Photo : albumId, id, title, url, thumbnailUrl 저장하는 data class
    + Post : userId, id, title, body 저장하는 data class
    + Comment : postId, id, name, email, body 저장하는 data class
  + ##### <mark>PhotoAdapter / PostAdapter / CommentAdapter</mark>
    + MainActivity 의 RecyclerView 에 각각 phone / post / comment 데이터 표시하는 Adapter class
</details>

<br>

### 5. App07
#### 1. Package fragment
  > Fragment 와 Activity 간 상호작용
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + setFragment() 메서드 사용하여 ListFragment 생성 및 설정
    + 버튼 클릭에 따른 Fragment 전환
</details>

#### 2. Package musicFragment
  > Fragment 사용
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + fun fragmentLayout(fragment : Fragment) 및 inner class ClickHandler() 에 따른 Fragment 전환
    + 버튼 클릭에 따라 Fragment_Album, Fragment_Song, Fragment_Artist 각각 Fragment 부착
</details>

<br>

### 6. App07_Frag
#### 1. Package fragment
  > ReceiverFragment 와 SenderFragment 통신
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + ReceiverFragment 와 SenderFragment 부착
</details>

#### 2. Package fragmentColor
  > ColorChangeReceiverFragment 와 ColorChangeSenderFragment 통신
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + ColorChangeReceiverFragment 와 ColorChangeSenderFragment 부착
</details>

<br>

### 7. App07_ViewPager
  > ViewPager 와 TabLayout 사용하여 Fragment 관리

<br>

### 8. App08_ViewPager
#### 1. Package adapter
  > ViewPager2 페이지 슬라이드
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + 슬라이드 할 페이지 색상, 제목 포함하는 DataPage 객체 리스트 생성
    + ViewPager2 ViewPagerAdapter 연결
    + 버튼 클릭 -> ViewPager2 슬라이드 방향 토글
  + ##### <mark>DataPage</mark>
    + color, title 저장하는 data class
  + ##### <mark>ViewPagerAdapter</mark>
    + MainActivity 의 ViewPage2 와 연결
    + 각 페이지의 데이터 표시하는 역할
    + DataPage 객체로 구성
</details>

#### 2. Package fragment
  > ViewPager2 사용 여러 개 Fragment 표시
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + ViewPager2 MyFragAdapter2 연결
  + ##### <mark>MyFragAdapter2</mark>
    + ViewPager2 와 함께 사용할 FragmentStateAdapter 정의
    + 여러 개 Fragment (FragmentOne, Two, Three, Four) 관리
    + 각 페이지 내용 동적 제공
</details>

#### 3. Package tab
  > ViewPager2 와 TapLayout 함께 사용
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity3</mark>
    + ViewPager2 ContentAdapter 연결
    + TabLayoutMediator 사용하여 TabLayout 과 ViewPager 연결
  + ##### <mark>ContentAdapter</mark>
    + FragmentTab1, 2, 3 이 담긴 Fragment 객체 리스트 생성
    + 여러 Fragmenet 관리
</details>

<br>

### 9. App08_menu
#### 1. MainActivity
  > 상단 툴바와 검색 기능 설정
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity</mark>
    + 슬라이드 할 페이지 색상, 제목 포함하는 DataPage 객체 리스트 생성
    + ViewPager2 ViewPagerAdapter 연결
    + 버튼 클릭 -> ViewPager2 슬라이드 방향 토글
  + ##### <mark>DataPage</mark>
    + color, title 저장하는 data class
  + ##### <mark>ViewPagerAdapter</mark>
    + MainActivity 의 ViewPage2 와 연결
    + 각 페이지의 데이터 표시하는 역할
    + DataPage 객체로 구성
</details>

#### 2. Package customMenu
  > ViewPager, ActionBarDrawerToggle 사용
<details>
  <summary>class</summary>

  + ##### <mark>MainActivity2</mark>
    + xml 에서 정의한 툴바 액션 바로 설정
    + ActionBarDrawerToggle 초기화하여 열기/닫기 상태 관리
    + onCreateOptionMenu 메서드로 메뉴 생성
    + searchView 의 쿼리 텍스트 리스너 설정
      + 사용자 검색어 입력 시, onQueryTextChange 호출하여 로그에 입력된 텍스트 출력
  + ##### <mark>MyAdapter</mark>
    + 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
  + ##### <mark>MyFragmentPagerAdapter</mark>
    + MainActivity2 의 ViewPage2 와 연결
    + FragmentOne, Two, Three 담긴 Fragment 객체 리스트 생성
    + 여러 Fragmenet 관리
</details>

<br>

### 10. App08_chapt12

<br>

### 11. App08_1
