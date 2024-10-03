let currentSlide = 0;
const images = [
    'img1.jpg',
    'img2.jpg',
    'img3.jpg',
    'img4.jpg',
	'img5.jpg',
	'img6.jpg'
	
];

function showSlide(index) {
    const slide = document.getElementById("slide");
    slide.src = images[index];
}

function nextSlide() {
    currentSlide = (currentSlide + 1) % images.length;
    showSlide(currentSlide);
}

function prevSlide() {
    currentSlide = (currentSlide - 1 + images.length) % images.length;
    showSlide(currentSlide);
}

// Initialize the slider with the first image
showSlide(currentSlide);
