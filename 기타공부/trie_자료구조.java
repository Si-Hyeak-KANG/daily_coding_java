/**
* 자료구조 트라이(Trie)는 문자열을 저장하고 효율적으로 탐색하기 위한 트리형 자료 구조.
* 문자열을 탐색할 때 단순히 비교하는 것에 비해 효율적
* 하지만 각 자식에 대한 링크를 갖고 있기 때문에 많은 저장 공간 차지
* 주로 검색어 자동완성, 사전 찾기 기능에서 사용
* 이진검색, O(logn)
**/
class TrieTest {
  @Test
  void trieTest() {
    Trie trie = new Trie();
    trie.insert("maeilmail");
    assertThat(trie.has("ma")).isTrue();
    assertThat(trie.has("maeil)).isTrue();
    assertThat(tire.has("maeilmail")).isTrue();
    assertThat(trie.has("mail")).isFalse();
  }

  class Trie {
    private final Node root = new Node("");
    
    public void insert(String str) {
      Node current = root;
      for (String ch : str.split("")) {
        if (!current.children.containsKey(ch)) {
          current.children.put(ch, new Node(current.value + ch));
        }
        current = current.children.get(ch);
      }
    }

    public boolean has(String str) {
      Node current = root;
      for (String ch : str.split("")) {
        if (!current.children.containsKey(ch)) {
          return false;  
        }
        current = current.children.get(ch);
      }
      return true;
    }
  }

  class Node {
    public String value;
    public Map<String, Node> children;

    public Node(String value) {
      this.value = value;
      this.children = new HashMap<>();
    }
  }
}
