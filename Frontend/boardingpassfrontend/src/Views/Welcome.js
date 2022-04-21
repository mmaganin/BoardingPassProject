import React from "react";
import SearchButton from "../Buttons/SearchButton";
import '../App.css';

class Welcome extends React.Component {
    constructor() {
        super();
        this.state = {
            from: "",
            dateTime: ""
        }
        this.handleFrom = this.handleFrom.bind(this)
        this.handleDatetime = this.handleDatetime.bind(this)
    };

    handleFrom(e) {
        this.setState({
            from: e.target.value
        })
    }

    handleDatetime(e) {
        this.setState({
            dateTime: e.target.value
        })
    }

    render() {
        return (
            <div className="welcome-page" >
                <div className="container">
                    <h1 className="display-2">Welcome to Boarding Pass!</h1>
                    <h2 className="display-5">Please enter you departure destination and departure time.</h2>
                    <p> eg: Atlantic Av-Barclays Ctr, 2022-04-20 13:08, date must be in "yyyy-MM-dd HH:mm" format</p>

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
                            Date and Time:
                        </span>
                        <input
                            type="text"
                            value={this.state.dateTime}
                            onChange={this.handleDatetime}
                            class="form-control"
                            aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-default"
                        ></input>
                    </div>
                    
                    <SearchButton 
                        from={this.state.from}
                        dateTime={this.state.dateTime}
                    />

                </div>
            </div>
        );
    }
};

export default Welcome;
