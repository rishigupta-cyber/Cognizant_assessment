import React, { Component } from 'react';
import './App.css';
import { books } from './books';
import { blogs } from './blogs';
import { courses } from './courses';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      books: books,
      blogs: blogs,
      courses: courses,
    };
  }

  render() {
    const bookdet = (
      <ul>
        {this.state.books.map((book) => (
          <div key={book.id}>
            <h3>{book.bname}</h3>
            <h4>{book.price}</h4>
          </div>
        ))}
      </ul>
    );

    const content =
      this.state.blogs.length > 0 ? (
        this.state.blogs.map((blog) => (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            <h4>{blog.author}</h4>
            <p>{blog.content}</p>
          </div>
        ))
      ) : (
        <p>No blogs available</p>
      );

    const coursedet = (
      <div>
        {this.state.courses.length > 0 &&
          this.state.courses.map((course, index) => (
            <div key={index}>
              <h3>{course.name}</h3>
              <h4>{course.date}</h4>
            </div>
          ))}
      </div>
    );

    return (
      <div className="container">
        <div className="mystyle1">
          <h1>Course Details</h1>
          {coursedet}
        </div>
        <div className="st2">
          <h1>Book Details</h1>
          {bookdet}
        </div>
        <div className="v1">
          <h1>Blog Details</h1>
          {content}
        </div>
      </div>
    );
  }
}

export default App;