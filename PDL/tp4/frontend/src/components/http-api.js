import axios from "axios";

const method = {
  file: "",
  response: [],
  updateList() {
    axios
      .get(`images`)
      .then((response) => {
        // JSON responses are automatically parsed.
        this.response = response.data;
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
  handleFileUpload() {
    this.file = this.$refs.file.files[0];
  },
  submitFile() {
    /*
              Initialize the form data
          */
    let formData = new FormData();

    /*
              Add the form data we need to submit
          */
    formData.append("file", this.file);

    /*
        Make the request to the POST /single-file URL
      */
    axios
      .post("/images", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then(function () {
        console.log("SUCCESS!!");
      })
      .catch(function () {
        console.log("FAILURE!!");
      });
    axios
      .get(`images`)
      .then((response) => {
        // JSON responses are automatically parsed.
        this.response = response.data;
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
}

export default method