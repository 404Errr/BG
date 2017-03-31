package data;

public interface GraphicsData {
//	WindowType WINDOW_FORMAT = WindowType.WINDOWED;
	WindowType WINDOW_FORMAT = WindowType.WINDOWED_FULLSCREEN;
//	WindowType WINDOW_FORMAT = WindowType.BORDERLESS_FULLSCREEN;
	enum WindowType {
		BORDERLESS_FULLSCREEN, WINDOWED_FULLSCREEN, WINDOWED
	}

	float DEFAULT_SCALE_RATIO = 0.035f;
	float DEFAULT_WINDOW_SCREEN_RATIO = 0.8f;

	int MARGIN = 100;
	int GRID_SIZE_X = 75;
	int GRID_SIZE_Y = 50;
	int BAR_WIDTH = GRID_SIZE_X*3/2;
}
