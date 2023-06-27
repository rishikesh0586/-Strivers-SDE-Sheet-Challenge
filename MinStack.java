class minStack {
  stack < pair < int, int >> st;

  public
    void push(int x) {
      int min;
      if (st.empty()) {
        min = x;
      } else {
        min = std::min(st.top().second, x);
      }
      st.push({x,min});
    }

  int pop() {
      if(st.empty())
          return -1;
      int top = st.top().first;
      st.pop();
    return top;
  }

  int top() {
      if(st.empty())
          return -1;
    return st.top().first;
  }

  int getMin(){
      if(st.empty())
          return -1;
    return st.top().second;
  }
};