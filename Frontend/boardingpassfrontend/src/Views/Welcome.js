import React from "react";
import SearchButton from "../Buttons/SearchButton";

class Welcome extends React.Component {
    constructor() {
        super();
        this.state = {
            from: "",
            to: "",
            redirectAfterSearch: false
        }
        this.handleFrom = this.handleFrom.bind(this)
        this.handleTo = this.handleTo.bind(this)
    };

    handleFrom(e) {
        this.setState({
            from: e.target.value
        })
        console.log(this.state.from)
    }
    handleTo(e) {
        this.setState({
            to: e.target.value
        })
        console.log(this.state.to)
    }
    handleSubmit(e) {
        e.preventDefault();
        this.setState({
            redirectAfterSearch: true
        })
        console.log(this.state.redirectAfterSearch)
    }

    render() {
        return (
            <div className="welcome-page" >
                <div className="container">
                    <h1 className="display-4">Welcome to Boarding Pass!</h1>
                    <h2 className="display-3">Please enter To and From destinations.</h2>
                    <p> eg: Los Angeles, CA, New York, NY</p>

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
                    <div class="search-form input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">
                            To:
                        </span>
                        <input
                            type="text"
                            value={this.state.to}
                            onChange={this.handleTo}
                            class="form-control"
                            aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-default"
                        ></input>
                    </div>
                    <SearchButton 
                        from={this.state.from}
                        to={this.state.to}
                    />

                </div>
            </div>
        );
    }
};

export default Welcome;
