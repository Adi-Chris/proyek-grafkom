#version 330

in vec4 out_color;
out vec4 fragColor;

void main() {
    // fragColor parameternya R, G, B, A
    //    fragColor = vec4(1.0f, 0.0f, 0.0f, 1.0f);

    fragColor = out_color;

}