import React from "react";
import SearchButton from "../Buttons/SearchButton";
import "../App.css";

class Welcome extends React.Component {
 constructor() {
  super();
  this.state = {
   from: "",
  };
  this.handleFrom = this.handleFrom.bind(this);
 }

 handleFrom(e) {
  this.setState({
   from: e.target.value,
  });
 }

 handleDate(e) {
  this.setState({
   date: e.target.value,
  });
 }

 handleFirstName(e) {
  this.setState({
   firstName: e.target.value,
  });
 }

 handleLastName(e) {
  this.setState({
   lastName: e.target.value,
  });
 }

 handleEmail(e) {
  this.setState({
   email: e.target.value,
  });
 }

 handlePhone(e) {
  this.setState({
   phoneNumber: e.target.value,
  });
 }

 handleAge(e) {
  this.setState({
   age: e.target.value,
  });
 }

 handleGender(e) {
  this.setState({
   selectedGender: e.target.value,
  });
 }

 render() {
  return (
   <div className="welcome-page">
    <div className="container">
     <h1 className="display-2">Welcome to Boarding Pass!</h1>
     <h2 className="display-5">Please enter your information:</h2>
     <div class="search-form input-group mb-3">
      <span className="input-group-text" id="inputGroup-sizing-default">
       Date Leaving:
      </span>
      <input
       type="text"
       value={this.state.date}
       onChange={this.handleDate}
       class="form-control"
       aria-label="Sizing example input"
       aria-describedby="inputGroup-sizing-default"
      ></input>
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
      <div class="input-group">
       <span class="input-group-text">First Name:</span>
       <input
        type="text"
        aria-label="First name"
        class="form-control"
        value={this.state.firstName}
       ></input>
       <span class="input-group-text">Last Name:</span>
       <input
        type="text"
        aria-label="Last name"
        class="form-control"
        value={this.state.lastName}
       ></input>
      </div>
      <div>
       <span class="input-group-text">Email Address:</span>
       <input
        type="text"
        aria-label="email"
        class="form-control"
        value={this.state.email}
       ></input>
      </div>
      <div>
       <span class="input-group-text">Phone Number:</span>
       <input
        type="text"
        aria-label="Phone Number"
        class="form-control"
        value={this.state.phoneNumber}
       ></input>
      </div>
      <div>
       <span class="input-group-text">Age:</span>
       <input type="text" aria-label="Age" class="form-control" value={this.state.age}></input>
      </div>
      <span className="input-group-text">Gender:</span>
      <div class="form-check">
       <input
        class="form-check-input"
        type="radio"
        name="flexRadioDefault"
        id="flexRadioDefault1"
        value="male"
        checked={this.state.selectedGender}
       ></input>
       <label class="form-check-label" for="flexRadioDefault1">
        Male
       </label>
      </div>
      <div class="form-check">
       <input
        class="form-check-input"
        type="radio"
        name="flexRadioDefault"
        id="flexRadioDefault2"
        value="female"
        checked={this.state.selectedGender}
       ></input>
       <div>
        <label class="form-check-label" for="flexRadioDefault2">
         Female
        </label>
       </div>
      </div>
     </div>
    </div>
    <SearchButton from={this.state.from} />
   </div>
  );
 }
}

export default Welcome;
