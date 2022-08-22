import React, { Component } from "react";
import ProductService from "../services/EmployeeService";

class ListEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [],
    };
    this.deleteEmployee = this.deleteEmployee.bind(this);
    this.addEmployee = this.addEmployee.bind(this);
    this.editEmployee = this.editEmployee.bind(this);
  }
  deleteEmployee(id) {
    ProductService.deleteEmployee(id).then(res => {
      this.setState({employees: this.state.employees.filter(employee => employee.id !== id)
      });
    });
  }
  viewEmployee(id){
    this.props.history.push(`/view-employee/${id}`);
  }
  editEmployee(id) {
    this.props.history.push(`/add-employee/${id}`);
  }
  componentDidMount() {
    ProductService.getProducts().then((res) => {
      this.setState({ employees: res.data });
    });
  }
  addEmployee() {
    this.props.history.push("/add-employee/-1");
  }
  render() {
    return (
      <div>
        <h2 className="text-center">Product List</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.addEmployee}>
            Add Product
          </button>
        </div>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Description</th>
                <th>Date Of Manufacture</th>
              </tr>
            </thead>
            <tbody>
              {this.state.employees.map((employees) => (
                <tr key={employees.id}>
                  <td>{employees.productName}</td>
                  <td>{employees.productPrice}</td>
                  <td>{employees.description}</td>
                  <td>{employees.dateOfManufacture}</td>
                  <td>
                    <button
                      onClick={() => this.editEmployee(employees.id)}
                      className="btn btn-info"
                    >
                      Update
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.deleteEmployee(employees.id)}
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.viewEmployee(employees.id)}
                      className="btn btn-primary"
                    >
                      View
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListEmployeeComponent;
