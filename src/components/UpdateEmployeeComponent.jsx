import React, { Component } from "react";
import ProductService from "../services/EmployeeService";
class UpdateEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      productName: "",
      productPrice: "",
      description: "",
    };
    this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
    this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
    this.changeEmailHandler = this.changeEmailHandler.bind(this);
    this.updateEmployee = this.updateEmployee.bind(this);
  }
  componentDidMount() {
    ProductService.getProductById(this.state.id).then((res) => {
      let employee = res.data;
      this.setState({
        productName: employee.productName,
        productPrice: employee.productPrice,
        description: employee.description,
      });
    });
  }
  updateEmployee = (e) => {
    e.preventDefault();

    let employee = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      emailId: this.state.emailId,
    };
    console.log("employee =>" + JSON.stringify(employee));
    ProductService.updateEmployee(employee, this.state.id).then(res => {
      this.props.history.push('/employees');
    });
  };

  cancel() {
    this.props.history.push("/employees");
  }
  changeFirstNameHandler = (event) => {
    this.setState({ productName: event.target.value });
  };
  changeLastNameHandler = (event) => {
    this.setState({ productPrice: event.target.value });
  };
  changeEmailHandler = (event) => {
    this.setState({ description: event.target.value });
  };
  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Update Product</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Product Name: </label>
                    <input
                      placeholder="Product Name"
                      name="productName"
                      className="form-control"
                      value={this.state.productName}
                      onChange={this.changeFirstNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Product Price: </label>
                    <input
                      placeholder="Product Price"
                      name="productPrice"
                      className="form-control"
                      value={this.state.productPrice}
                      onChange={this.changeLastNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Description: </label>
                    <input
                      placeholder="Description"
                      name="description"
                      className="form-control"
                      value={this.state.description}
                      onChange={this.changeEmailHandler}
                    />
                  </div>
                  <button
                    className="btn btn-success"
                    onClick={this.updateEmployee}
                  >
                    save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UpdateEmployeeComponent;
