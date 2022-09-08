async function onFormSubmit() {
  let myform = document.forms["farmerForm"];
  const name = myform.name.value;
  const age = myform.age.value;
  const gender = myform.gender.value;
  const nameError = document.getElementById("error");
  const ageError = document.getElementById("error1");
  const genderError = document.getElementById("error2");
  let nameFlag = false;
  let ageFlag = false;
  let genderFlag = false;

  //name validation
  if (name === "" || name == null) {
    nameError.innerText = "Farmer name cannot be empty";
  } else if (name < 5) {
    nameError.innerText =
      "Farmer name should be greater than 5 char and max 12";
  } else {
    nameFlag = true;
    nameError.innerText = "";
  }

  //age validation
  if (age == "" || age == null) {
    ageError.innerText = "Age is required";
  } else if (parseInt(age) < 18 || parseInt(age) > 100) {
    ageError.innerText = "Farmer age must be between 18 -100";
  } else {
    ageFlag = true;
    ageError.innerText = "";
  }

  //gender validation
  if (gender === "" || gender == null) {
    genderError.innerText = "Atleast one must be selected";
  } else {
    genderFlag = true;
    genderError.innerText = "";
  }
  
  let checkFlags = (arr) => arr.every(Boolean);
  
  if (checkFlags([nameFlag, ageFlag, genderFlag])) {
    await fetch("/farmer/addnewfarmer_v3", {
      method: "POST",
      headers: { "Content-type": "application/json;charset=UTF-8" },
      body: JSON.stringify({
        name:name,
        age:age,
        gender:gender,
      }),
    })
      .then((res) => res.json())
      .then((res) => {
        console.log(res.message);
        document.getElementById("msg").innerText = res.message;
        document.forms["farmerForm"].name.value = "";
        document.forms["farmerForm"].age.value = "";
        document.forms["farmerForm"].gender.value = "";
      })
      .catch((err) => console.error(err));
  }
}
