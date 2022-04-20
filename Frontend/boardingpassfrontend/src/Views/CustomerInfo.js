import React from 'react'
import SearchButton from "../Buttons/SearchButton";

class CustomerInfo extends React.Component {
  constructor() {
    super();
    this.state = {
      from: "",
    }
    this.handleFrom = this.handleFrom.bind(this)
  };

  handleFrom(e) {
    this.setState({
      from: e.target.value
    })
  }

  handleInputs() {

  }

  render() {
    return (
      <div className="welcome-page" >
        <div className="container">
          <h1 className="display-4">Please Enter Your Information...</h1>

          <div class="search-form input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">
              From:
            </span>
            <input
              type="text"
              value={this.state.from}
              onChange={this.handleFrom}
              class="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-default"
            ></input>
          </div>

          <SearchButton
            from={this.state.from}
          />

        </div>
      </div>
    );
  }
};



export default CustomerInfo