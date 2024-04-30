package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Test
    public void testGetProduct_Successful() throws IncompatibleDataFormatException, ApiCallFailureException {
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        Product product = new Product("7854","product1",18000.00);
        when(mockApiClient.getProduct("7854")).thenReturn(product);
        ProductService productService = new ProductService(mockApiClient);
        Product actualProduct  = productService.getProduct("7854");
        assertEquals(product, actualProduct);
        verify(mockApiClient).getProduct("7854");
    }
    @Test
    public void testGetProduct_IncompatibleDataFormat() throws IncompatibleDataFormatException,ApiCallFailureException  {
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        when(mockApiClient.getProduct("7854")).thenThrow(new IncompatibleDataFormatException());
        ProductService productService = new ProductService(mockApiClient);

        try {
            productService.getProduct("7854");
        } catch (IncompatibleDataFormatException | ApiCallFailureException e) {

        }
        verify(mockApiClient).getProduct("7854");
    }
    @Test
    public void testGetProduct_ApiCallFailure() throws IncompatibleDataFormatException ,ApiCallFailureException{
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        when(mockApiClient.getProduct("7854")).thenThrow(new ApiCallFailureException());
        ProductService productService = new ProductService(mockApiClient);
        try {
            productService.getProduct("7854");
        } catch (IncompatibleDataFormatException | ApiCallFailureException e) {

        }
        verify(mockApiClient).getProduct("7854");
    }

}
