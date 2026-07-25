import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
      amount: '',
      currency: ''
    };

    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handlePress = this.handlePress.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
  }

  // Increment button invokes TWO methods:
  // a. increments the counter, b. says hello with a static message
  increment() {
    this.setState({ counter: this.state.counter + 1 });
    alert('Hello! Member1');
  }

  decrement() {
    this.setState({ counter: this.state.counter - 1 });
  }

  // takes "welcome" as an argument
  sayWelcome(name) {
    alert(name);
  }

  // synthetic event handler - "Click on me" button
  handlePress(e) {
    alert('I was clicked');
  }

  handleAmountChange(e) {
    this.setState({ amount: e.target.value });
  }

  handleCurrencyChange(e) {
    this.setState({ currency: e.target.value });
  }

  // Currency conversion - rate: 1 unit = 80
  handleSubmit() {
    const value = parseFloat(this.state.amount) * 80;
    alert('Converting to  ' + this.state.currency + ' Amount is ' + value);
  }

  render() {
    return (
      <div className="App">
        <p>{this.state.counter}</p>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome('welcome')}>Say welcome</button>
        <button onClick={this.handlePress}>Click on me</button>

        <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
        <p>
          Amount:{' '}
          <input type="text" value={this.state.amount} onChange={this.handleAmountChange} />
        </p>
        <p>
          Currency:{' '}
          <input type="text" value={this.state.currency} onChange={this.handleCurrencyChange} />
        </p>
        <button onClick={this.handleSubmit}>Submit</button>
      </div>
    );
  }
}

export default App;