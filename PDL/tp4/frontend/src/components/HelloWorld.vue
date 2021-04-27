<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div id="v-model-select-dynamic" class="image">
      <select v-model="selected">
        <option
          v-for="option in response"
          v-bind:key="option.id"
          v-on:click="setImage(option)"
        >
          {{ option.name }}
        </option>
        <span>{{ selected }}</span>
      </select>
    </div>
    <img :src="getImage()" />

    <div class="container">
      <div class="large-12 medium-12 small-12 cell">
        <label
          >File
          <input
            type="file"
            id="file"
            ref="file"
            v-on:change="method.handleFileUpload()"
          />
        </label>
        <button v-on:click="method.submitFile()">Submit</button>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      response: [],
      errors: [],
      imgUlr: "",
    };
  },
  mounted() {
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
  methods: {
    setImage(option) {
      this.imgUlr = option.url;
    },
    getImage() {
      return this.imgUlr;
    },
  },
};
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

img {
  width: 50%;
}
</style>