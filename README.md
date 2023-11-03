# oop_baseball_game
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.  
예) 상대방(컴퓨터)의 수가 425일 때  
123을 제시한 경우 : 1스트라이크  
456을 제시한 경우 : 1볼 1스트라이크  
789를 제시한 경우 : 낫싱  
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.  
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.  
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.  
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.  


SOLID 원칙 적용 1차  
- SRP - print, pitcher, player, referee 클래스 분리로 하나의 클래스는 하나의 책임만 가지도록 설계  
- OCP - exception을 check하는 인터페이스 사용, 상태를 출력하는 인터페이스 사용, 아웃 판정 인터페이스 사용 -> 확장에는 개방적, 수정에는 폐쇄적 -> 수정이 필요할 시 확장해서 구현하면 됨
- LSP - 개념 이해가 좀 더 필요  
- ISP - Judgeable인터페이스에서는 아웃판정만 할 수 있음 -> 인터페이스 단일 책임 원칙 준수 -> 볼, 스트라이크 판정도 해야한다면 인터페이스를 분리시켜야함
- DIP - OCP와 비슷한 개념 -> DIP를 지키면 OCP가 지켜지는 느낌.

피드백 1차
- 메소드 네이밍 고민해보기 -> 직접 해본 결과 역할 분리가 쉬워짐
- SOLID 원칙을 모두 지키기에는 힘들다. -> 현재 구현한 게임에도 LSP를 적용시킬 부분을 찾지 못함
- is-a, has-a관계 이해 필요 -> LSP 사각형 문제 이해가 도움됨
- 추후 전략패턴, 템플릿 메소드 패턴 적용하며 이해 필요

SOLID 원칙 적용 2차  
- OCP - Player와 Pitcher 클래스를 생성 -> 구현체 클래스에 의존하지 않고 인터페이스에 의존함
- DIP - Game에서 interface타입으로 선언해 의존성을 고모듈 클래스에 둠
