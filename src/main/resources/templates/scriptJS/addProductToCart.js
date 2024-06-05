document.getElementById('addToCart').addEventListener('click', function () {
    const name = this.getAttribute('data-name');
    const price = this.getAttribute('data-price');

    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.push({name, price});
    localStorage.setItem('cart', JSON.stringify(cart));

    alert('Товар додано до корзини');
});
