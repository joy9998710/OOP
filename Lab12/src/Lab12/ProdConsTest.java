package Lab12;

public class ProdConsTest {
	public static void main(String[] args) {
		ProdCons a = new ProdCons();
		a.startThread();
	}
}

/*솔직히 여러곳 찾아보고 생각도 해보았지만 정말 마땅한 답을 찾지 못해 나의 생각을 적도록 하겠다
먼저 처음에는 if문으로 검사를 하면 단일하게 검사하므로 wait에서 Thread가 깨어날 때 race condition 이 발생할 수 있다고 생각하였다
하지만 그런 상황은 synchronized 함수이기에 발생할 수 없다. 왜냐하면 synchronized 함수에서는 한 번에 하나의 Thread만 함수로 진입한다. 때문에 이런 상황은
발생 할 수가 없다. 더하여 buffer에 더 많은 원소가 while문을 if문으로 고친다고 해서 buffer가 꽉 차 있을 때 들어가지 않는다. 그 이유인 즉슨, add가 실행되는 동안 wait 상태에 있는 Thread는 오직 하나이기 때문이다
때문에 wait 상태에 있는 Thread가 다른 함수에서 notifyAll()에 의해 깨어나더라도 그 Thread만 계산을 수행할 것이므로 결과는 같을 것이다. 실제로 if문으로 바꿔도 while문과 차이가 없게 돌아갔다
적어도 이번 예시에서는 synchronized가 있기에 나는 while문과 if문의 차이가 없을 것이라 생각한다 */