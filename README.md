# oop_baseball_game
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

# Game Rule
같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.  
예) 상대방(컴퓨터)의 수가 425일 때  
123을 제시한 경우 : 1스트라이크  
456을 제시한 경우 : 1볼 1스트라이크  
789를 제시한 경우 : 낫싱  
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.  
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.  
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.  
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.  


## SOLID 원칙 적용 1차  
- SRP - print, pitcher, player, referee 클래스 분리로 하나의 클래스는 하나의 책임만 가지도록 설계  
- OCP - exception을 check하는 인터페이스 사용, 상태를 출력하는 인터페이스 사용, 아웃 판정 인터페이스 사용 -> 확장에는 개방적, 수정에는 폐쇄적 -> 수정이 필요할 시 확장해서 구현하면 됨
- LSP - 개념 이해가 좀 더 필요  
- ISP - Judgeable인터페이스에서는 아웃판정만 할 수 있음 -> 인터페이스 단일 책임 원칙 준수 -> 볼, 스트라이크 판정도 해야한다면 인터페이스를 분리시켜야함
- DIP - OCP와 비슷한 개념 -> DIP를 지키면 OCP가 지켜지는 느낌.

## 피드백 1차
- 메소드 네이밍 고민해보기 -> 직접 해본 결과 역할 분리가 쉬워짐
- SOLID 원칙을 모두 지키기에는 힘들다. -> 현재 구현한 게임에도 LSP를 적용시킬 부분을 찾지 못함
- is-a, has-a관계 이해 필요 -> LSP 사각형 문제 이해가 도움됨
- 추후 전략패턴, 템플릿 메소드 패턴 적용하며 이해 필요

## 피드백 적용 1차 
- Game에서 Player와 Pitcher 클래스 인스턴스 생성시 interface타입으로 생성해 의존성을 인터페이스에 둠 -> 인터페이스를 통해 기존코드를 수정 시 확장으로 해결 가능 및 인터페이스에 의존함
- 기존에는 Printer가 심판 판정 구조체에 의존성을 둠 -> 심판 판정 중 스트라이크, 볼을 카운트하는 메소드도 인터페이스로 추상화함 -> 심판 인터페이스에 의존성을 둠

## 피드백 2차
- 매개변수로 인터페이스타입을 받아 구현하면 결합도가 높아지는게 보임
- 변수명 및 메소드명을 명확하게 표현
- 스택 overflow가 나지 않도록 로직 구현
- 불필요한 함수 호출을 최소화
- 인스턴스 선언을 필요한 부분에서만 하기

## 피드백 적용 2차
- 기존에 printer에서 매개변수로 Judgeable 타입으로 받던 메소드를 자료형으로 받도록 변환
- 사용자가 입력한 값 리스트의 변수명을 player에서 좀더 구체적인 inputBall로 변경
- Game로직의 while문에서 while문이 끝나기 전에 재귀함수 호출로 인한 Stack OverFlow가 발생한 부분을 while문 밖에서 재귀함수를 호출하도록 변경
- Judge에서 isOut함수에 countStrike메소드를 판정할때마다 호출했지만 Strike와 Ball을 생성자로 넣음으로써 반복 호출 방지 -> countBall, countStrike 메소드에서는 로직만 수행 -> 볼과 스트라이크 카운트를 리턴하는 getBallCount, getStrikeCount 메소드 추가
- Game클래스에서 Judgeable 인스턴스를 startGame안에서 선언 -> startGame에서만 사용하기 때문

## 피드백 3차
- printer 인터페이스 때문에 불필요한 함수가 많아짐
- while문안에서 객체를 계속 생성할 필요가 있을까?
- askRestart 메소드 네이밍 다시생각
- startGame과 askRestart 메소드가 서로 반복호출 함으로써 스택오버플로우가 날 수 있음

## 피드백 적용 3차
- printer 인터페이스 삭제 -> 불필요한 함수 삭제
- judge 인스턴스를 while문 밖에서 생성하도록 코드 수정
- askRestart 메소드 리턴타입을 boolean으로 변경함으로 써 네이밍을 isRestart로 변경
- 기존에 서로 호출하던 메소드를 재귀함수로 변경

# UML
[![image](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=oop_baseball_game.drawio#R7Vxbd9o4EP41nNN9IMd34DFA0jabttmml919E7YC2hiL2iKB%2Fvod2fJdBIMxkBP39LRoPJZkzTejucju6KP56r2PFrNP1MFuR1OcVUcfdzRN7Vka%2FMcp64jS65sRYeoTRzClhHvyGwuiIqhL4uAgx8godRlZ5Ik29TxssxwN%2BT59zrM9UDc%2F6gJNcYlwbyO3TP1JHDYTVMs00gsfMJnOxNCarlvRlTmKucWjBDPk0OcMSb%2Fq6COfUhb9mq9G2OWrFy%2FMz4%2Frn%2B7to%2FX%2B5q%2FgF%2Fo%2B%2FPPb5x%2FdqLPrXW5JnsHHHtu7a%2F9vOv5Erpwv12xoezfG6r5niluUJ%2BQuxYK9R3Msnpet41UMnsncRR60hg%2FUY%2Ffiigpt5JKpB79tmBv2gfCEfUZAAJfiAqMLoNoz4jq3aE2X%2FAkChuzHuDWcUZ%2F8hm6RK%2FqEyz4TWNKsHMc9vxPIClB9HADPXbwsaoH0Ca1yjLcoYIJgU9dFi4BMkseYI39KvCFljM4F0%2FOMMHy%2FQDbneQb14BNh83iSD8R1R9SlfrhE%2Bti4Uq9NoFcUlhAqXy28ymBVCO89pnPM%2FDWwiKvaoB%2FdIjRRF7J7TmGtWYI2yyJaEUQkVGmadJ2M9hVUD3lTWI3McEpuOFUtj9eTDKcXRkMuwMJDDA%2Fp0nOCLEThR%2BZBU1II3B1ArJZA3OUSIMyeASJBV%2FVL%2BPeOtxGXuGa5HHYTuGZN%2Ba%2BQ3UXrDPcVR%2FNm7v%2BWzhQnzDe8tZk5sBNOsExg5%2FySggEGWAh8nz7iGFUejTQuAzRBipXOxQ9so8oFAF3iTW9DnrGRUr4KaXEShXsf3NCszYjjYI%2BrC2WIoUg3uCIsKPFYKE5zCH9BwCPlwuyYMPERtNW0DX85u89G1INnQSRUAQyK94y58m3TqbLuvGi1tuvOOlaMarpiGZtVJYfaXSGqlSBagoBLQtFGEIj3qqKhqSb%2FOUjSxanAv3E8jLtqCRR6GRS6BAAummD3jgaEEcr79yPeAjC2yT4PbuKBchLWoNAHFQ1kvyGZ6xKZD0OZw%2B7Gt9l3fyR24YlCVyXjEfGT4CsO78nwT8CHwsjbYMq4pcsw3xJYf81Cc65tIf9HsG5TboYEUYwm64x4iyU7VGcODU3lu8qdjCpyylfSIU%2B5Rwm%2BgL%2BxYQlBxBn21kAf10DHvs02XVUVrSFtNSTaGiFjkUOC9WvJHX7hMAKUlMUqaXZDwV4aIYlDpiuAcJm4x2kPKdaicUiGkMF7Gf3%2BAxdPUd0kygcLQYqjZK2LoMSEkocE90%2BK3EBbFGkz7jcFcewXP5%2B6%2BVF3WdJIhcSayroc1jd5%2BYcqqL5ceQsanlFTbg46IlCK1kTVRPsazYnLIf8Bu0%2BY95pXL5n2NRVPGMVwQrJdKlIVfCGeqKWCZquCpUji9ahguLtudlFkkz70HIQAvEmwyIwCm6onHWiC7Mepz8PSrh1t35ehwwNuLk9FSEY5sv8CaxZN%2FiX5vw1rZanKdnMl9xiaMle97TEd9pxLnsSEFl2ErhtQrsMVD1cQWtlFz6xtCEvsCAcPFtNf%2F80bF2bc%2FCd7bbzKtdZxa0VYdJuiWKLN71MvFFU00zt5I3vjHcRnsFLcZIa03UQb0KVv4%2B3hEQQ2U%2FySLykcM%2BzkEr1loDxn07tC5j52ESNP%2BVzwC3mwO%2B5Ip6BL%2BlkXABZ3ET2kuCubey10pGtbOopWodTRoTJk%2FSNCNYHcoN%2FPQm5nvO0L%2BhPh1DwdTq1%2BIVfb3xOnPc2UW9kj4XRw%2Fib1ROjST2gG%2B1ovDy9jT3gZRXs6OC68Yh8ig6%2B7uErQVrzOruJViFCNXsUItW815PGp8kqTTeeLJcsUjyqHB22SsUaSMdHmWmUgGYC0xgDU1oFq14F2F7upVbQbTUl9UyVo76xlazeOajesihtPc3ajXJ24iU4gtG7L2bktxVSVIYPPzid16uGnnFqv57hUOEFTqy9Qf%2FKYHrAJ4wEZ3wTxhUhYWrtYxy4alZF%2BLsdqVKv1p2r7UzuL%2FdQHa1RZ5v2litKE%2Bg72s0WeJ%2BS%2F63az9D%2FCFVOS4hP85vWn%2FL9HqoAdZ75vslp2%2BmVXAgyqvPQYGAcwOO6GU2BnN22bz7kw4cy%2BfJ7zvQ%2F9iHTGjWM%2BvyKvAo8LHyb9FQdLl21eqBew2TpdR3W6Tn9ULnayKpZpJi7lkeDQQcEsLL%2BIMo0o2kQllnpFG7VTtQ5udtKSZFKFlJYkdwsPtxZ64qDwnOvdZj5wNXuFeLRqnUdTt3TUcJ1HL6dL3txJstILLK%2FoJNmhjpy%2F5QNTunZ25zv1chbqTuSM2jTm2aUxiwCqXH4dNJXt0cvZnkPnHe0Z5uLm%2FYz4z8iAth5uDQ830fqDl2n1xoBW4Whnm1Y8tNirVtkae19Pdkqylj%2FS2o2j2g1LEhkftUyr73Z%2B8ZCB8ekD3FheZ32U0dAGF%2FkjroZl7hfklrvSj3yqOz6G%2BZbD3IyX9trC3NDX%2FAGL7SC%2BUVctk2x%2FafwtB715jbQkHy1JklPZLaGYoDrca8XlXGkq8hC8bfB7lsFvPoPZk31tR5MAqbgFHA5IskOEbUyyU0ySKGOtUFQm9qZiEkOWyT7g5tFGKDUilN3hFLu%2B2%2BDUWIRiyN6xP06E8npLd7Gct5fulNNFNmrh83D9vr5fXFPsqNcrGLeGoxqzhege1WWjIkRP%2BJZqT9FzwDL3RWixI2NwZITKTp2eYdyNveUc%2B6F%2F0EDkzb9gBgECWwavKfQeffn87ePn71e7n8baa7irz%2BMjjXT%2F8d8XH%2Br0%2BQ5QyRgvdY4P1vpEDTiEjHhL%2FA6GrnhQ97wyJ4VA%2BDr8s%2FN%2BUj0QHmhGztbKjhGoA4kLW3pJfB8fVv11%2BZ8x7s7UX3%2BOP%2Bja4GdwQ6XfVdzsH6QfCcguf85b2OgQHHiTjgtMh%2FMjhZCUC0WNXy1tJGme9wit4gmR6inzXiFlnmzlW7butKuYkT48BHjH7R2a6ee6I%2Fb0q%2Bf61f8%3D)
]









