
function typeWriter(elementId, text, speed) {
  var i = 0;
  var element = document.getElementById(elementId);
  function type() {
    if (i < text.length) {
      element.innerHTML += text.charAt(i);
      i++;
      setTimeout(type, speed);
    } else {
      setTimeout(function() {
        element.innerHTML = "";
        i = 0;
        type();
      }, 2000);
    }
  }
  type();
}

