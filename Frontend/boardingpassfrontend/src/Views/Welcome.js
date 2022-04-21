import React from "react";
import SearchButton from "../Buttons/SearchButton";
import "../App.css";

class Welcome extends React.Component {
    constructor() {
        super();
        this.state = {
            from: "",
            date: "",
            firstName: "",
            lastName: "",
            email: "",
            phoneNumber: "",
            age: "",
            selectedGender: false
        };
        this.handleFrom = this.handleFrom.bind(this);
        this.handleDate = this.handleDate.bind(this);
        this.handleFirstName = this.handleFirstName.bind(this);
        this.handleLastName = this.handleLastName.bind(this);
        this.handleEmail = this.handleEmail.bind(this);
        this.handlePhone = this.handlePhone.bind(this);
        this.handleAge = this.handleAge.bind(this);
        this.handleGender = this.handleGender.bind(this);

    }

    handleFrom(e) {
        this.setState({
            from: e.target.value
        });
    }

    handleDate(e) {
        this.setState({
            date: e.target.value
        });
    }

    handleFirstName(e) {
        this.setState({
            firstName: e.target.value
        });
    }

    handleLastName(e) {
        this.setState({
            lastName: e.target.value
        });
    }

    handleEmail(e) {
        this.setState({
            email: e.target.value
        });
    }

    handlePhone(e) {
        this.setState({
            phoneNumber: e.target.value
        });
    }

    handleAge(e) {
        this.setState({
            age: e.target.value
        });
    }

    handleGender(e) {
        this.setState({
            selectedGender: true
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
                            Date Leaving: (eg. "2022-04-20 13:08" format: YYYY-MM-DD HH:mm)
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
                            From: (eg. Atlantic Av-Barclays Ctr)
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
                                onChange={this.handleFirstName}
                            ></input>
                            <span class="input-group-text">Last Name:</span>
                            <input
                                type="text"
                                aria-label="Last name"
                                class="form-control"
                                value={this.state.lastName}
                                onChange={this.handleLastName}
                            ></input>
                        </div>
                        <div>
                            <span class="input-group-text">Email Address:</span>
                            <input
                                type="text"
                                aria-label="email"
                                class="form-control"
                                value={this.state.email}
                                onChange={this.handleEmail}

                            ></input>
                        </div>
                        <div>
                            <span class="input-group-text">Phone Number:</span>
                            <input
                                type="text"
                                aria-label="Phone Number"
                                class="form-control"
                                value={this.state.phoneNumber}
                                onChange={this.handlePhone}
                            ></input>
                        </div>
                        <div>
                            <span class="input-group-text">Age:</span>
                            <input
                                type="text"
                                aria-label="Age"
                                class="form-control"
                                value={this.state.age}
                                onChange={this.handleAge}>

                            </input>
                        </div>
                        <span className="input-group-text">Gender:</span>
                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="flexRadioDefault"
                                id="male"
                                value={this.state.selectedGender}
                                checked
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
                                id="female"
                                value={this.state.selectedGender}
                            ></input>
                            <div>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Female
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <SearchButton from={this.state.from} dateTime={this.state.date} />
            </div>
        );
    }
}

export default Welcome;
