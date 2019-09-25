var buttons = document.getElementsByTagName('button');

Array.prototype.forEach.call(buttons, function (b) {;
	b.addEventListener('click', createRipple);
	b.addEventListener("touchstart", mouseDown);
	b.addEventListener("touchend", mouseUp);
});

function createRipple (e) {
    var circle = document.createElement('div');
    this.appendChild(circle);
    var d = Math.max(this.clientWidth, this.clientHeight);
    circle.style.width = circle.style.height = d + 'px';
	var rect = this.getBoundingClientRect();
	circle.style.left = e.clientX - rect.left -d/2 + 'px';
	circle.style.top = e.clientY - rect.top - d/2 + 'px';
    circle.classList.add('ripple');
	var ele = this;
	setTimeout(()=>{
		ele.removeChild(circle);
	},600)
}

function mouseDown (e) {
	e.currentTarget.classList.add("test");
	e.currentTarget.classList.add("test2");
}

function mouseUp (e) {
	e.currentTarget.classList.remove("test");
	e.currentTarget.classList.remove("test2");
}